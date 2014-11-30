package com.carm.oso.domain

import com.wordnik.swagger.annotations.ApiModel
import com.wordnik.swagger.annotations.ApiModelProperty
import grails.persistence.Entity

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */

@Entity
@ApiModel(value = "User", description = "User resource for Oso App")
class User implements Serializable {

    static final long serialVersionUID = 1L

    @ApiModelProperty(value = "User's id", required = true)
    Integer id
    @ApiModelProperty(value = "User's name", required = true)
    String name
    @ApiModelProperty(value = "User's first surname", required = true)
    String firstSurname
    @ApiModelProperty(value = "User's second surname", required = true)
    String secondSurname
    @ApiModelProperty(value = "User's e-mail address", required = true)
    String email
    @ApiModelProperty(value = "User's phone", required = true)
    String phone
    @ApiModelProperty(value = "User's company", required = true)
    String companyId
    @ApiModelProperty(value = "User's password", required = true)
    String password
    @ApiModelProperty(value = "User's email validation", required = true)
    Boolean emailValidated
    @ApiModelProperty(value = "User's account locked", required = true)
    Boolean accountLocked
    @ApiModelProperty(value = "User's expiration password", required = true)
    Boolean passwordExpired
    @ApiModelProperty(value = "User's organizations URL", required = true)
    String organizationsUrl

    static mapping = {
        table "user_oso"
        version false
        id generator: "sequence",
                params: [column: "id"]
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
        name blank: false, nullable: false
        firstSurname blank: false, nullable: false
        email blank: false, nullable: false
        password blank: false, nullable: false

        secondSurname blank: true, nullable: true
        phone blank: true, nullable: true
        companyId blank: true, nullable: true
        emailValidated blank: true, nullable: true
        accountLocked blank: true, nullable: true
        passwordExpired blank: true, nullable: true
        organizationsUrl blank: true, nullable: true

    }
}
