package gitlet;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

/** Represents a gitlet commit object.
 *
 *  does at a high level.
 *
 *  @author Olivia Kim
 */
public class Commit {
    /**
     *
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /**
     * The message of this Commit.
     */
    private String message;
    private Date date;
    private String id;
    private final File file;
    private HashMap<String, String> trackedFile;



    public Commit() {
        this.message = "initial commit";
        /*  00:00:00 UTC, Thursday, 1 January 1970 */
        this.date = new Date(0);
        /* commit id */
        this.id = shaId();
        /* file under commit directory */
        this.file = Utils.join(Repository.COMMIT_DIR, this.id);
        /* file it's tracking (null) */
        this.trackedFile = new HashMap<String, String>();
    }

    public Commit(String msg) {
        this.message = msg;
        this.id = shaId();
        this.file = Utils.join(Repository.COMMIT_DIR, this.id);
    }
    /* SHA1 id for commit */
    public String shaId() {
        return Utils.sha1(this.message);
    }

}


