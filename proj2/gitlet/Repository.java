package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
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

    /* TODO: fill in the rest of this class. */

    /* init method */
    public static void init() {
        if (GITLET_DIR.exists()){
            System.out.println("A Gitlet version-control system already exists in the current directory.");
        } else {
            GITLET_DIR.mkdir();
            STAGING_DIR.mkdir();
            COMMIT_DIR.mkdir();
            BLOB_DIR.mkdir();
            BRANCH_DIR.mkdir();
            // need initial commit, head pointer, commit id
            Commit commitZero = new Commit();

        }

    }




}
