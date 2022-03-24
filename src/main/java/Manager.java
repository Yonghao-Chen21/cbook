import java.util.Scanner;

import com.careerit.cbook.domain.AppUser;
import com.careerit.cbook.service.AppUserService;
import com.careerit.cbook.service.AppUserServiceImpl;

public class Manager {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		AppUserService appUserService = new AppUserServiceImpl();

		System.out.println("Please enter your Username");
		String name = input.nextLine();
		System.out.println("Please enter your Password");
		String password = input.nextLine();

		AppUser appUser = appUserService.findUserByNameAndPassword(name, password);

		if (appUser != null) {
			System.out.println("id : " + appUser.getUid());
			System.out.println("name : " + appUser.getName());
			System.out.println("email : " + appUser.getEmail());
			System.out.println("phone : " + appUser.getMobile());
			System.out.println("dob : " + appUser.getDob());

		} else {
			System.out.println("User is not present");
		}
	}
}
