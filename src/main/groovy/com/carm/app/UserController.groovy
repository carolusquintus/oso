package com.carm.app

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
}
