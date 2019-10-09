package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import entities.Person;
import utils.EMF_Creator;
import facades.RegisterFacade;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@OpenAPIDefinition(
            info = @Info(
                    title = "Simple Register API",
                    version = "0.1",
                    description = "Simple API to get info about a registerd person.",        
                    contact = @Contact( name = "Gruppe 9", email = "cph-ao141@cphbusiness.dk")
            ),
          tags = {
                    @Tag(name = "register", description = "API related to Movie Info")
              
            },
            servers = {
                    @Server(
                            description = "For Local host testing",
                            url = "http://localhost:8080/startcode"
                    )//,
//                    @Server(
//                            description = "Server API",
//                            url = "http://mydroplet"
//                    )
                          
            }
    )

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class RegisterResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",   
            "jdbc:mysql://localhost:3307/startcode",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final RegisterFacade FACADE = RegisterFacade.getRegisterFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonCount() {
        long count = FACADE.getPersonCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    /* @Operation(summary = "Get all persons in a list",
            tags = {"persons"},
            responses = {
                     @ApiResponse(
                     content = @Content(mediaType = "application/json",schema = @Schema(implementation = PersonDTO.class))),
                    @ApiResponse(responseCode = "200", description = "All persons"),                       
                    @ApiResponse(responseCode = "400", description = "Persons not found")})*/
    public String getAllPersons() {
        List<Person> per = FACADE.getAllPersons();
        return GSON.toJson(per);
    }

    @Path("/get/{phone}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonByPhone(@PathParam("phone") int phone) {
        Person p = FACADE.getPersonByPhone(phone);
        return GSON.toJson(p);
    }
    @Path("/insertdata")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String insertData() {

        FACADE.insertData();
        return "{\"msg\":\"Done\"}";
    }
    
    /*
    @Path("/get/all/{city}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonByCity(@PathParam("city") String city) {
        List<Person> p = FACADE.getAllFromCity(city);
        return GSON.toJson(p);
    }*/
    
//    @Path("/get/all/{hobbie}")
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getPersonByCity(@PathParam("hobbie") String hobbie) {
//        List<Person> p = FACADE.findAllPersonswithHobbie(hobbie);
//        return GSON.toJson(p);
//    }
    
//    @Path("/get/count/{hobbie}")
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getPersonByCity(@PathParam("hobbie") strring hobbie) {
//        int p = FACADE.getAllHobbieCount(hobbie);
//        return GSON.toJson(p);
//    }
    
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public String editPerson(String personAsJson, @PathParam("id") int id) {
////        Date date = new Date();
//        
//        Person pOrignal = FACADE.getPerson(id);
//        Person NewPersonVal = GSON.fromJson(personAsJson, Person.class);
//        pOrignal.setName(NewPersonVal.getName());
//        pOrignal.setPhone(NewPersonVal.getPhone());
//        pOrignal.setAddress(NewPersonVal.getAddress());
//        
//        // makes that the value return is on a good json format
//        return GSON.toJson(pOrignal);
//    }
    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String addPerson(String personAsJson) {
//        Person personNew = gson.fromJson(personAsJson, Person.class);
//        persons.put(nextId, personNew);
//        personNew.setId(nextId);
//        nextId++;
//        System.out.println("val sent");
//        return gson.toJson(personNew);
//    }
    
    //Delete er ikke testet endnu - 
//    @DELETE
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Path("{phone}")
//    public String deletePerson(@PathParam("phone") int phone){
//        Person p = FACADE.getPersonByPhone(phone);
//        int id = p.getId();
//        Person p1 = FACADE.deletePerson(id);
//        return GSON.toJson(p1);
//        
//    }
    
    

}
