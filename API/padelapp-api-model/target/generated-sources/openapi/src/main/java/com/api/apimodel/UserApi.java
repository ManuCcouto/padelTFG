/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api.apimodel;

import com.api.model.BookingDTO;
import java.util.List;
import com.api.model.UserDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")
@Validated
@Api(value = "user", description = "the user API")
public interface UserApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /user : Create user
     * This can only be done by the logged in user.
     *
     * @param userDTO Created user object (optional)
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Create user", nickname = "createUser", notes = "This can only be done by the logged in user.", response = UserDTO.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserDTO.class) })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDTO> _createUser(@ApiParam(value = "Created user object") @Valid @RequestBody(required = false) UserDTO userDTO) {
        return createUser(userDTO);
    }

    // Override this method
    default  ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastName\" : \"James\", \"role\" : \"LEVEL_ADMIN\", \"level\" : 5, \"description\" : \"Admin user with full access\", \"firstName\" : \"John\", \"password\" : \"12345\", \"phone\" : \"12345\", \"memberClub\" : { \"onHold\" : false, \"startDate\" : \"2022-01-01T00:00:00Z\", \"dni\" : \"12345678A\", \"endTDate\" : \"2022-12-31T23:59:59Z\" }, \"startTime\" : \"2022-01-01T00:00:00Z\", \"id\" : 10, \"endTime\" : \"2022-12-31T23:59:59Z\", \"sport\" : \"Soccer\", \"email\" : \"john@email.com\", \"username\" : \"theUser\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/createWithList : Creates list of users with given input array
     * Creates list of users with given input array
     *
     * @param userDTO  (optional)
     * @return Successful operation (status code 200)
     *         or successful operation (status code 200)
     */
    @ApiOperation(value = "Creates list of users with given input array", nickname = "createUsersWithListInput", notes = "Creates list of users with given input array", response = UserDTO.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = UserDTO.class),
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/createWithList",
        produces = { "application/json", "application/xml" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDTO> _createUsersWithListInput(@ApiParam(value = "") @Valid @RequestBody(required = false) List<UserDTO> userDTO) {
        return createUsersWithListInput(userDTO);
    }

    // Override this method
    default  ResponseEntity<UserDTO> createUsersWithListInput(List<UserDTO> userDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastName\" : \"James\", \"role\" : \"LEVEL_ADMIN\", \"level\" : 5, \"description\" : \"Admin user with full access\", \"firstName\" : \"John\", \"password\" : \"12345\", \"phone\" : \"12345\", \"memberClub\" : { \"onHold\" : false, \"startDate\" : \"2022-01-01T00:00:00Z\", \"dni\" : \"12345678A\", \"endTDate\" : \"2022-12-31T23:59:59Z\" }, \"startTime\" : \"2022-01-01T00:00:00Z\", \"id\" : 10, \"endTime\" : \"2022-12-31T23:59:59Z\", \"sport\" : \"Soccer\", \"email\" : \"john@email.com\", \"username\" : \"theUser\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<UserDTO> <id>10</id> <username>theUser</username> <firstName>John</firstName> <lastName>James</lastName> <email>john@email.com</email> <password>12345</password> <phone>12345</phone> <level>5</level> <description>Admin user with full access</description> <startTime>2022-01-01T00:00Z</startTime> <endTime>2022-12-31T23:59:59Z</endTime> <sport>Soccer</sport> <role>LEVEL_ADMIN</role> </UserDTO>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /user/{username} : Delete user
     * This can only be done by the logged in user.
     *
     * @param username The name that needs to be deleted (required)
     * @return Deleted (status code 204)
     *         or Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @ApiOperation(value = "Delete user", nickname = "deleteUser", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/user/{username}"
    )
    default ResponseEntity<Void> _deleteUser(@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("username") String username) {
        return deleteUser(username);
    }

    // Override this method
    default  ResponseEntity<Void> deleteUser(String username) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/{username}/bookings : Get the bookings of a user
     *
     * @param username The name that needs to be fetched. Use user1 for testing.  (required)
     * @return successful operation (status code 200)
     *         or Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @ApiOperation(value = "Get the bookings of a user", nickname = "getBookingsUser", notes = "", response = BookingDTO.class, responseContainer = "List", tags={ "user","booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = BookingDTO.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/{username}/bookings",
        produces = { "application/json" }
    )
    default ResponseEntity<List<BookingDTO>> _getBookingsUser(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") String username) {
        return getBookingsUser(username);
    }

    // Override this method
    default  ResponseEntity<List<BookingDTO>> getBookingsUser(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ownerUser\" : { \"firstName\" : \"John\", \"lastName\" : \"James\", \"phone\" : \"12345\", \"id\" : 10, \"email\" : \"john@email.com\", \"username\" : \"theUser\" }, \"idBooking\" : 10, \"resourceDTO\" : { \"number\" : 12, \"timeSlot\" : 90, \"name\" : \"Pista central\", \"daysInAdvance\" : 3, \"endTimeSlot\" : \"00:00:00\", \"id\" : 2, \"startTimeSlot\" : \"09:00:00\", \"basePrice\" : 5.5 }, \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"starDate\" : \"2017-07-21T17:30:00Z\", \"price\" : 0.8008281904610115, \"guessts\" : { \"firstName\" : \"John\", \"lastName\" : \"James\", \"phone\" : \"12345\", \"id\" : 10, \"email\" : \"john@email.com\", \"username\" : \"theUser\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/{username} : Get user by user name
     *
     * @param username The name that needs to be fetched. Use user1 for testing.  (required)
     * @return successful operation (status code 200)
     *         or Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @ApiOperation(value = "Get user by user name", nickname = "getUserByName", notes = "", response = UserDTO.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserDTO.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/{username}",
        produces = { "application/json" }
    )
    default ResponseEntity<UserDTO> _getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") String username) {
        return getUserByName(username);
    }

    // Override this method
    default  ResponseEntity<UserDTO> getUserByName(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastName\" : \"James\", \"role\" : \"LEVEL_ADMIN\", \"level\" : 5, \"description\" : \"Admin user with full access\", \"firstName\" : \"John\", \"password\" : \"12345\", \"phone\" : \"12345\", \"memberClub\" : { \"onHold\" : false, \"startDate\" : \"2022-01-01T00:00:00Z\", \"dni\" : \"12345678A\", \"endTDate\" : \"2022-12-31T23:59:59Z\" }, \"startTime\" : \"2022-01-01T00:00:00Z\", \"id\" : 10, \"endTime\" : \"2022-12-31T23:59:59Z\", \"sport\" : \"Soccer\", \"email\" : \"john@email.com\", \"username\" : \"theUser\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/login : Logs user into the system
     *
     * @param email The user name for login (optional)
     * @param password The password for login in clear text (optional)
     * @return successful operation (status code 200)
     *         or Invalid username/password supplied (status code 400)
     */
    @ApiOperation(value = "Logs user into the system", nickname = "loginUser", notes = "", response = String.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = String.class),
        @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/login",
        produces = { "application/json" }
    )
    default ResponseEntity<String> _loginUser(@ApiParam(value = "The user name for login") @Valid @RequestParam(value = "email", required = false) String email,@ApiParam(value = "The password for login in clear text") @Valid @RequestParam(value = "password", required = false) String password) {
        return loginUser(email, password);
    }

    // Override this method
    default  ResponseEntity<String> loginUser(String email, String password) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/logout : Logs out current logged in user session
     *
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Logs out current logged in user session", nickname = "logoutUser", notes = "", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/logout"
    )
    default ResponseEntity<Void> _logoutUser() {
        return logoutUser();
    }

    // Override this method
    default  ResponseEntity<Void> logoutUser() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /user/{username} : Update user
     * This can only be done by the logged in user.
     *
     * @param username name that need to be deleted (required)
     * @param userDTO Update an existent user in the store (optional)
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Update user", nickname = "updateUser", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/user/{username}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> _updateUser(@ApiParam(value = "name that need to be deleted", required = true) @PathVariable("username") String username,@ApiParam(value = "Update an existent user in the store") @Valid @RequestBody(required = false) UserDTO userDTO) {
        return updateUser(username, userDTO);
    }

    // Override this method
    default  ResponseEntity<Void> updateUser(String username, UserDTO userDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
