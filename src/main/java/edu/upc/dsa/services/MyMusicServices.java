package edu.upc.dsa.services;

import edu.upc.dsa.*;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/MyMusic", description = "Endpoint to My edu.upc.dsa.MyMusic Service")
@Path("/MyMusic")

public class MyMusicServices {
        private MyMusic myMusic;

        public MyMusicServices() throws UserNotFoundException, PlaylistNotFoundException {
            this.myMusic = MyMusicImpl.getInstance();

            this.myMusic.addUser("id", "Juan", "Lopex");
            this.myMusic.addArtist("Lola", "Lopez");
            this.myMusic.addArtist("Pepe", "Tez");

            this.myMusic.addPlayList("id", "09");

            this.myMusic.addTitol("id","09","nombre","res","lola","perez", 22);
            this.myMusic.addTitol("id","09","nombre2","nada","juan","Gonzalez", 2);

        }

    @POST
    @ApiOperation(value = "add user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {
        if (u.getIdUser()== null || u.getName()== null || u.getSurname()== null)
            return Response.status(500).build();
        this.myMusic.addUser(u.getIdUser(), u.getName(), u.getSurname());
        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "add artist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/artist")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addArtist(Artist u) {
        if (u.getIdArtist()== null || u.getName()== null || u.getSurname()== null)
            return Response.status(500).build();
        this.myMusic.addArtist(u.getName(), u.getSurname());
        return Response.status(201).build();
    }
    @POST
    @ApiOperation(value = "add playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 406, message = "UserNotFoundException")
    })
    @Path("/user/{idUser}/playlist")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlaylist(@PathParam("idUser") String idUser, PlayList u ) {
        try{
        this.myMusic.addPlayList(idUser, u.getName());
        return Response.status(201).build();
        }catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(406).build();
        }
    }

    @POST
    @ApiOperation(value = "add Titol")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 406, message = "UserNotFoundException"),
            @ApiResponse(code = 409, message = "UserNotFoundException")
    })
    @Path("/user/{idUser}/playlist/{namePlaylist}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTitol(@PathParam("idUser") String idUser,@PathParam("namePlaylist") String namePlaylist, Titol u ) {
        try{
            this.myMusic.addTitol(idUser, namePlaylist, u.getName(), u.getAlbum(), u.getArtista().getName(), u.getArtista().getSurname(), u.getDuració());
            return Response.status(201).build();
        }catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(406).build();
        }
        catch (PlaylistNotFoundException e) {
            e.printStackTrace();
            return Response.status(409).build();
        }
    }

    @GET
    @ApiOperation(value = "get list of artists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful")
    })
    @Path("/artist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListArtists() {
            List<Artist> artists = this.myMusic.artists();
            GenericEntity<List<Artist>> entity = new GenericEntity<List<Artist>>(artists) {};
            return Response.status(200).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get a list of titulos from a playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 406, message = "UserNotFoundException"),
            @ApiResponse(code = 409, message = "UserNotFoundException")

    })
    @Path("/user/{idUser}/playlist/{namePlaylist}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListPlaylist(@PathParam("idUser") String idUser,@PathParam("namePlaylist") String namePlaylist) {
       try {
           List<String> list = this.myMusic.listPlaylist(idUser, namePlaylist);
           GenericEntity<List<String>> entity = new GenericEntity<List<String>>(list) {};
           return Response.status(200).entity(entity).build();
       }catch (UserNotFoundException e) {
           e.printStackTrace();
           return Response.status(406).build();
       }
       catch (PlaylistNotFoundException e) {
           e.printStackTrace();
           return Response.status(409).build();
       }

    }

}
