package com.carm.oso

import com.carm.oso.domain.User
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import com.wordnik.swagger.annotations.ApiParam
import com.wordnik.swagger.annotations.ApiResponse
import com.wordnik.swagger.annotations.ApiResponses
import org.springframework.dao.DataIntegrityViolationException

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.FormParam
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED
import static javax.ws.rs.core.MediaType.APPLICATION_JSON
import static javax.ws.rs.core.MediaType.TEXT_HTML

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */
@Path("/user")
@Api(value = "/user", description = "Manage users")
class UserController {

    @GET
    @Produces(APPLICATION_JSON)
    @ApiOperation(
            value = "Find user by name",
            notes = "Find user by name",
            response = User.class
    )
    @ApiResponses(
            @ApiResponse(code = 404, message = "User with that name doesn't exists")
    )
    User userByName(
            @ApiParam(value = "Name to lookup for", required = true)
            @QueryParam("name") String name) {
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
    @Path("/delete/{id}")
    @Produces(APPLICATION_JSON)
    Response deleteUser(@PathParam("id") Integer id) {
        try {
            User user = User.get(id)
            user.delete()
            return Response.status(204).entity("User deleted correctly").build()
        } catch (Exception e) {
            return Response.status(404).entity("User with id: ${id} not found").build()
        }
    }

    @POST
    @Path("/add")
    @Produces(APPLICATION_JSON)
    Response addUser(
            @FormParam("name") String name, @FormParam("firstSurname") String firstSurname,
            @FormParam("secondSurname") String secondSurname, @FormParam("email") String email,
            @FormParam("phone") String phone, @FormParam("companyId") String companyId,
            @FormParam("password") String password, @FormParam("emailValidated") Boolean emailValidated,
            @FormParam("accountLocked") Boolean accountLocked, @FormParam("passwordExpired") Boolean passwordExpired,
            @FormParam("organizationsUrl") String organizationsUrl
    ) {
        User user = new User(
                name: name, firstSurname: firstSurname,
                secondSurname: secondSurname, email: email,
                phone: phone, companyId: companyId,
                password: password, emailValidated: emailValidated,
                accountLocked: accountLocked, passwordExpired: passwordExpired,
                organizationsUrl: organizationsUrl
        )

        try {
            user.save(flush: true, insert: true, validate: true, failOnError: true)
            return Response.status(201).entity("User created correctly").build();
        } catch (Exception e) {
            e.printStackTrace()
            return Response.status(406).entity(e.printStackTrace()).build();
        }
    }

    @PUT
    @Path("/update/{id}")
    @Produces(APPLICATION_JSON)
    Response updateUserById(
            @PathParam("id") Integer id,
            @FormParam("name") String name, @FormParam("firstSurname") String firstSurname,
            @FormParam("secondSurname") String secondSurname, @FormParam("email") String email,
            @FormParam("phone") String phone, @FormParam("companyId") String companyId,
            @FormParam("password") String password, @FormParam("emailValidated") Boolean emailValidated,
            @FormParam("accountLocked") Boolean accountLocked, @FormParam("passwordExpired") Boolean passwordExpired,
            @FormParam("organizationsUrl") String organizationsUrl
    ) {
        User user = new User(
                id: id,
                name: name, firstSurname: firstSurname,
                secondSurname: secondSurname, email: email,
                phone: phone, companyId: companyId,
                password: password, emailValidated: emailValidated,
                accountLocked: accountLocked, passwordExpired: passwordExpired,
                organizationsUrl: organizationsUrl
        )

        try {
            user.save(flush: true, insert: false, validate: false, failOnError: true)
            return Response.status(200).entity("User updated correctly").build();
        } catch (Exception e) {
            e.printStackTrace()
            return Response.status(406).entity(e.printStackTrace()).build();
        }
    }
}
