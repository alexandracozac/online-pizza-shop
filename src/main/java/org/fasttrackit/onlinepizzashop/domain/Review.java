package org.fasttrackit.onlinepizzashop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String content;
}
