package gitlet;

import java.io.File;
import static gitlet.Utils.*;
import static java.lang.System.exit;



/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     *
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    /* the staging area directory */
    public static final File STAGING_DIR = join(GITLET_DIR, "stagingArea");
    /* the commit directory */
    public static final File COMMIT_DIR = join(GITLET_DIR, "commits");
    /* the blob directory */
    public static final File BLOB_DIR = join(GITLET_DIR, "blobs");
    /* the branch directory */
    public static final File BRANCH_DIR = join(GITLET_DIR, "branches");


    /* init method */
    public static void init() {
        if (GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
        } else {
            GITLET_DIR.mkdir();
            STAGING_DIR.mkdir();
            COMMIT_DIR.mkdir();
            BLOB_DIR.mkdir();
            BRANCH_DIR.mkdir();

            Commit commitZero = new Commit();
            Branch main = new Branch(commitZero);
            String commitZeroId = commitZero.shaId();
        }
    }

    public static void add(String fileName) {
        File file = Utils.join(Repository.STAGING_DIR, fileName);
        if (file.exists()) {
            Utils.writeContents(file, (Utils.readContentsAsString(file)));
            /** check if the contents of the file changed,
             * if so put it in staging area **/

        } else {
            System.out.println("File does not exist.");
            exit(0);
        }

    }

    public static void commit(String msg) {

    }




}
