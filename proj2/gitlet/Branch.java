package gitlet;

public class Branch {

    private String mainBranch;
    private String headBranch;
    private String mainBranchId;

    public Branch(Commit commitZero) {
        this.mainBranch = "main";
        this.headBranch = "HEAD";
        Utils.join(Repository.BRANCH_DIR, mainBranch);
        Utils.join(Repository.BRANCH_DIR, headBranch);

    }

}
