package com.practice.projectboardadmin.repository;

import com.practice.projectboardadmin.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<AdminAccount, String> {
}