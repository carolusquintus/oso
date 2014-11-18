package com.carm.oso

import org.springframework.dao.DataIntegrityViolationException

import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response

import static javax.ws.rs.core.MediaType.APPLICATION_JSON
import static javax.ws.rs.core.MediaType.TEXT_HTML

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */
@Path("/user")
class UserController {

    @GET
    @Produces(APPLICATION_JSON)
    User userByName(@QueryParam("name") String name) {
        User u = User.findByName(name)
        return u
    }

    @GET
    @Path("/all")
    @Produces(APPLICATION_JSON)
    List<User> allUsers() {
        List<User> users = User.findAll()
        return users
    }

    @DELETE
    @Path("/delete")
    @Produces(TEXT_HTML)
    Response deleteUser(@QueryParam("id") Integer id) {
        try {
            User user = User.get(id)
            user.delete()
            return Response.status(204).build()
        } catch (DataIntegrityViolationException e) {
            return Response.status(404).entity("Could not delete person ${user.id}").build()
        }
    }

    /*
    //@RequestMapping(value = "/user/add", method = RequestMethod.POST)
    //@ResponseBody
    ResponseEntity addUser(String name, String firstSurname, String email, String password) {
        User.withTransaction {
            User u = new User(name: name, firstSurname: firstSurname, email: email, password: password).save()
            return new ResponseEntity( u ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
        }
    }*/
}
