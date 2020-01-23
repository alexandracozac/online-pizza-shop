package org.fasttrackit.onlinepizzashop.persistance;

import org.apache.tomcat.jni.User;
import org.fasttrackit.onlinepizzashop.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<User>findByEmailAndPassword (String email, String password);



}
