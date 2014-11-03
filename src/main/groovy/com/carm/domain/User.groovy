package com.carm.domain

import grails.persistence.Entity

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */

@Entity
class User {

    String id
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
        table 'USER_OSO '
        id column: 'ID'
        name column: 'NAME'
        firstSurname column: 'FIRST_SURNAME'
        secondSurname column: 'SECOND_SURNAME'
        email column: 'EMAIL'
        phone column: 'PHONE'
        companyId column: 'COMPANY_ID'
        password column: 'PASSWORD'
        emailValidated column: 'EMAIL_VALIDATED'
        accountLocked column: 'ACCOUNT_LOCKED'
        passwordExpired column: 'PASSWORD_EXPIRED'
        organizationsUrl column: 'ORGANIZATIONS_URL'
    }

    static constraints = {
        id blank:false
        name blank:false
        firstSurname blank:false
        email blank:false
        password blank:false
    }
}
