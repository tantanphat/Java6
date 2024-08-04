package com.example.java6.API;

import com.example.java6.Entity.store.Account;
import com.example.java6.Exception.ValidException;
import com.example.java6.Service.AccountService;
import com.example.java6.Service.FileManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("/rest/account")
public class AccountAPI {
    @Autowired
    private AccountService accountService;
    @Autowired
    private FileManagerService fileManagerService;
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllAccount() {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAllAccount());
    }

    @GetMapping("")
    public ResponseEntity<?> getAccountByUsername(@RequestParam("username") String username)   {
        try {
            Optional<Account> account = Optional.of(accountService.getAccountByUsername(username));
            return ResponseEntity.ok(account.get());
        } catch (Exception ex) {
            throw new ValidException("Lỗi khi lấy Account " + username + "", ex.getMessage());
        }
    }

    private final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir")+ "/src/main/resources/static/");

    @PostMapping("")
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {
        try {

            accountService.addAccount(account);
            return ResponseEntity.status(HttpStatus.CREATED).body("Đã được tạo thành công");
        } catch (Exception ex) {
            throw new ValidException("Lỗi khi tạo Account", ex.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<?> updateAccount(@Valid @RequestBody Account account) {
        try {
            accountService.updateAccount(account);
            return ResponseEntity.status(HttpStatus.OK).body("Tài khoản đã được cập nhật thành công");
        } catch (Exception ex) {
            throw new ValidException("Lỗi khi Update Account", ex.getMessage());
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAccount(@RequestParam("username") String username) {
        try {
            accountService.deleteAccount(username);
            return ResponseEntity.status(HttpStatus.OK).body("Tài khoản đã được xóa thành công");
        } catch (Exception ex) {
            throw new ValidException("account", ex.getMessage());
        }
    }

}
