package com.carm.oso

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */

@RestController
@RequestMapping("/rest")
class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    User userByName(@RequestParam("name") String name) {
        User u = User.findByName(name)
        return u
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity addUser(String name, String firstSurname, String email, String password) {
        User.withTransaction {
            User u = new User(name: name, firstSurname: firstSurname, email: email, password: password).save()
            return new ResponseEntity( u ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
        }
    }
}
