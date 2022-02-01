package com.jayklef.bhis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

    @ManyToOne
    private User userId;

    @ManyToOne
    private Book bookId;

}
