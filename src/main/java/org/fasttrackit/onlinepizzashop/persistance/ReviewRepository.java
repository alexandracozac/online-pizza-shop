package org.fasttrackit.onlinepizzashop.persistance;

import org.fasttrackit.onlinepizzashop.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {


}
