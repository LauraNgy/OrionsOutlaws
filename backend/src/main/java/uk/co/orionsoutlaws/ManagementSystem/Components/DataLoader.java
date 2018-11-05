package uk.co.orionsoutlaws.ManagementSystem.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import uk.co.orionsoutlaws.ManagementSystem.Enums.HunterStatus;
import uk.co.orionsoutlaws.ManagementSystem.Models.Assignment;
import uk.co.orionsoutlaws.ManagementSystem.Models.Bounty;
import uk.co.orionsoutlaws.ManagementSystem.Models.Customer;
import uk.co.orionsoutlaws.ManagementSystem.Models.Hunter;
import uk.co.orionsoutlaws.ManagementSystem.Repositories.AssignmentRepository.AssignmentRepository;
import uk.co.orionsoutlaws.ManagementSystem.Repositories.BountyRepository.BountyRepository;
import uk.co.orionsoutlaws.ManagementSystem.Repositories.CustomerRepository.CustomerRepository;
import uk.co.orionsoutlaws.ManagementSystem.Repositories.HunterRepository.HunterRepository;

@Component
public class DataLoader  implements ApplicationRunner {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BountyRepository bountyRepository;

    @Autowired
    HunterRepository hunterRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {

        Customer customer = new Customer("Jabba", 1000, "jabba@hutt.tat");
        customerRepository.save(customer);
        Customer customer2 = new Customer("Rick", 1000, "picklerick@wabadaba.com");
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Uk Government", 2000, "ukGov@gov.uk");
        customerRepository.save(customer3);


        Bounty bounty = new Bounty("Han", 100, -1.976460, 281.694603, "", customer);
        bountyRepository.save(bounty);
        Bounty bounty2 = new Bounty("Jerry", 10, -1.976460, 281.694603, "", customer2);
        bountyRepository.save(bounty2);
        Bounty bounty3 = new Bounty("The Master", 100000, -1.976460, 281.694603, "", customer3);
        bountyRepository.save(bounty3);

        Hunter hunter = new Hunter("Dog", "dog@wehuntu.com", 100, "https://romanolawpc.com/wp-content/uploads/2017/06/bail-in-oregon.jpg", HunterStatus.ALIVE);
        hunterRepository.save(hunter);
        Hunter hunter2 = new Hunter("Bobba Fett", "bobba@fett.co.uk", 100, "https://pbs.twimg.com/profile_images/977943902769496064/k68wjfzV_400x400.jpg", HunterStatus.ALIVE);
        hunterRepository.save(hunter2);
        Hunter hunter3 = new Hunter("Krombopulos Michael", "lovekillin@hereigo.com", 100, "https://pbs.twimg.com/profile_images/894809145315950592/ZS11JXni_400x400.jpg", HunterStatus.ALIVE);
        hunterRepository.save(hunter3);
        Hunter hunter4 = new Hunter("IG-88", "ig88ROXXX@gmail.com", 100, "https://cdna.artstation.com/p/assets/images/images/001/791/968/20160114112028/smaller_square/josh-herman-ig88final.jpg", HunterStatus.ALIVE);
        hunterRepository.save(hunter4);

        Assignment assignment = new Assignment(bounty, hunter);
        assignmentRepository.save(assignment);
        Assignment assignment2 = new Assignment(bounty2, hunter2);
        assignmentRepository.save(assignment2);
        Assignment assignment3 = new Assignment(bounty3, hunter3);
        assignmentRepository.save(assignment3);
        Assignment assignment4 = new Assignment(bounty, hunter2);
        assignmentRepository.save(assignment4);


    }
}
