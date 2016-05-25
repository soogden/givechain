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
import givechain.errors.insufficientFundsException;
import givechain.repository.CharityRepository;
import givechain.repository.ProjectRepository;
import givechain.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/action")
public class ActionRest
{
    private static final Logger logger = LoggerFactory.getLogger(ActionRest.class);


    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;

    @ApiOperation(value = "donate", nickname = "donate")
    @RequestMapping(method = RequestMethod.GET, path="/donate/{projectID}/{user}/{amount}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String payUser(@PathVariable String projectID,@PathVariable String user, @PathVariable String amount)
    {
    	int value = Integer.decode(amount);
    	int userAct = Integer.decode(user);
    	//use the Payment processor to deduct value from the user's credit card
    	//use the blockchain to increase the project's amount by x and return some blockchain ID
        return "{giveCoinID}";
    }
    
    @ApiOperation(value = "spend", nickname = "spend")
    @RequestMapping(method = RequestMethod.GET, path="/spend/{projectID}/{amount}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String spendMoney(@PathVariable String projectID, @PathVariable String amount)
    {
    	int value = Integer.decode(amount);
    	//Use the blockchain to check that Payment has more than the amount of money or throw inssuficicent funds exception
    	//transfer the money from the blockchain to a new wallet.
    	//return wallet ID
        return "{wallet ID}";
    }
    
    
    @ApiOperation(value = "checkValue", nickname = "checkValue")
    @RequestMapping(method = RequestMethod.GET, path="/checkValue/{walletID}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public int checkValue(@PathVariable String walletID)
    {
   
    	//Use the blockchain to check the value in the wallet and return it (for now just in givecoins)
        return 20;
    }
    
    @ApiOperation(value = "redeem", nickname = "redeem")
    @RequestMapping(method = RequestMethod.GET, path="/redeem/{walletID}/{recipient}/{amount}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public void redeem(@PathVariable String walletID,@PathVariable String recipient, @PathVariable String amount) throws insufficientFundsException
    {
    	int value = Integer.decode(amount);
    	int recipientAct = Integer.decode(recipient);

    	if (checkValue(walletID)< value) { throw new insufficientFundsException();}
    	//decrease wallet by amount
    	//start payout flow for recipient

    }
    
    @ApiOperation(value = "getLedger", nickname = "CheckLedger")
    @RequestMapping(method = RequestMethod.GET, path="/getLedger/{giveCoinID}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String getLedger(@PathVariable String giveCoinID) 
    {
    	
    	//use bitcoin to extract all ledger entries relating to this givecoin
    	return "{Ledger}";

    }
  
  
}
