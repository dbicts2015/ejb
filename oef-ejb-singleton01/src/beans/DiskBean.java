package beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class Disk
 */
// TODO: nodige annotations toevoegen:
// injecteerbaar in zelfde container
// singleton (i.e. bijzondere stateless session bean)
// creatie bij installatie

@Singleton
@LocalBean
@Startup
public class DiskBean {
	private List<String> directories = new ArrayList<>();

	public DiskBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void readDisk() {
		System.out.println("Lezen van disk...");
		File root = new File("C:\\");
		for (File file : root.listFiles()) {
			if (file.isDirectory() && !file.isHidden()) {
				directories.add(file.getName());
			}
		}
		System.out.println("Gelezen");
	}

	public String[] getDirectories() {
		return directories.toArray(new String[directories.size()]);
	}

}
