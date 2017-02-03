package gamaset.sonicboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamaset.sonicboot.service.ReadGamesTodayService;
import gamaset.sonicboot.service.objectpages.GamesTodayPage;

@RestController
public class ControllerApp {

	@Autowired
	private ReadGamesTodayService readGamesTodayService;

	@RequestMapping(method = RequestMethod.GET, value = "/games")
	public GamesTodayPage test(){
		
		return readGamesTodayService.read();
	}
	
}
