package com.carm.app

import grails.persistence.Entity

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */

@Entity
class User implements Serializable {

    static final long serialVersionUID = 1L

    Integer id
    String name
    String firstSurname
    String secondSurname
    String email
    String phone
    String companyId
    String password
    Boolean emailValidated
    Boolean accountLocked
    Boolean passwordExpired
    String organizationsUrl

    static mapping = {
        table 'user_oso'
        version false
        id column: 'id'
        name column: 'name'
        firstSurname column: 'first_surname'
        secondSurname column: 'second_surname'
        email column: 'email'
        phone column: 'phone'
        companyId column: 'company_id'
        password column: 'password'
        emailValidated column: 'email_validated'
        accountLocked column: 'account_locked'
        passwordExpired column: 'password_expired'
        organizationsUrl column: 'organizations_url'
    }

    static constraints = {
        id blank:false
        name blank:false
        firstSurname blank:false
        email blank:false
        password blank:false
    }
}
