package dev.leandromodena.apicrud

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("accounts")
class AccountController(val repository: AccountRepository) {

    @PostMapping
    fun create(@RequestBody account: Account) = ResponseEntity.ok(repository.save(account))

    @GetMapping
    fun read() = ResponseEntity.ok(repository.findAll())

    @PutMapping("{document}")
    fun update(@PathVariable document: String, @RequestBody account: Account): ResponseEntity<Account> {
        val optionalDocument = repository.findByDocument(document)
        val toSave = optionalDocument.orElseThrow { RuntimeException("Account document:  $document not exist") }
            .copy(name = account.name, balance = account.balance)
        return ResponseEntity.ok(repository.save(toSave))
    }

    @DeleteMapping("{document}")
    fun delete(@PathVariable document: String) = repository.findByDocument(document).ifPresent { repository.delete(it) }

}
