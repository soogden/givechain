package givechain.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import givechain.domain.CProject;
import givechain.domain.Charity;
import givechain.repository.CharityRepository;
import givechain.repository.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/charity")
public class CharityRest
{
    private static final Logger logger = LoggerFactory.getLogger(CharityRest.class);


    @Autowired
    CharityRepository charityRepository;
    @Autowired
    ProjectRepository projectRepository;

    @ApiOperation(value = "getCharities", nickname = "getCharities")
    @RequestMapping(method = RequestMethod.GET, path="/getCharities")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Charity> listCharities()
    {
        return charityRepository.findAll();
    }
    
    @ApiOperation(value = "getProjects", nickname = "getProjects")
    @RequestMapping(method = RequestMethod.GET, path="/getProjects/{charityID}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<CProject> listProjects(@PathVariable String charityID)
    {
        return projectRepository.findByCharity(charityID);
    }
  
}
