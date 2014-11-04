package com.carm.web

import com.carm.domain.User
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */

@RestController
class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String userByName(/*String name*/) {
        //def u = User.findByName(name)
        return /*u ? "Hello ${u.name}" : */"Person not found"
    }
}
