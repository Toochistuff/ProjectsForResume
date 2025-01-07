package osSim;


public class PCB {
    public static final String NEW = "new";
    public static final String READY = "ready";
    public static final String RUNNING = "running";
    public static final String WAITING = "waiting";
    public static final String TERMINATED = "terminated";
	private int jobID;
    private int[] registers;
    private int programCounter;
    private int startAddress;
    private int endAddress;
    private String state; // Possible states: "new", "ready", "running", "waiting", "terminated"
    private int dataStartAddress = -1;
    private int dataEndAddress = -1;
    private int diskStartAddress; // New field
    private int diskEndAddress;   // New field

    // Constructor
    public PCB(int jobID, int startAddress, int endAddress, int diskStartAddress, int diskEndAddress) {
        this.jobID = jobID;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.programCounter = startAddress;
        this.registers = new int[16]; // Assuming 16 general-purpose registers
        this.state = "new";
        this.diskStartAddress = diskStartAddress;
        this.diskEndAddress = diskEndAddress;
    }

    // Getter and Setter for jobID
    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    // Getter and Setter for registers
    public int[] getRegisters() {
        return registers;
    }

    public void setRegisters(int[] registers) {
        if (registers != null && registers.length == 16) {
            this.registers = registers.clone(); // Clone to prevent reference issues
        } else {
            throw new IllegalArgumentException("Registers array must have a length of 16.");
        }
    }

    // Getter and Setter for programCounter
    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    // Getter and Setter for startAddress
    public int getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    // Getter and Setter for endAddress
    public int getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(int endAddress) {
        this.endAddress = endAddress;
    }

    // Getter and Setter for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        // Debug Statement
        System.out.printf("PCB: Job ID %d changing state from %s to %s%n", this.jobID, this.state, state);
        this.state = state;
    }

    // Reset registers to zero
    public void resetRegisters() {
        this.registers = new int[16];
    }
    
    public void setDataStartAddress(int address) {
        this.dataStartAddress = address;
    }

    public int getDataStartAddress() {
        return dataStartAddress;
    }

    public void setDataEndAddress(int address) {
        this.dataEndAddress = address;
    }

    public int getDataEndAddress() {
        return dataEndAddress;
    }
    public int getDiskStartAddress() {
        return diskStartAddress;
    }

    public void setDiskStartAddress(int diskStartAddress) {
        this.diskStartAddress = diskStartAddress;
    }

    public int getDiskEndAddress() {
        return diskEndAddress;
    }

    public void setDiskEndAddress(int diskEndAddress) {
        this.diskEndAddress = diskEndAddress;
    }

    // Display PCB information (for debugging purposes)
    public void displayPCBInfo() {
        System.out.println("PCB Information:");
        System.out.println("Job ID: " + jobID);
        System.out.println("Program Counter: " + programCounter);
        System.out.println("Start Address: " + startAddress);
        System.out.println("End Address: " + endAddress);
        System.out.println("State: " + state);
        System.out.println("Registers:");
        for (int i = 0; i < registers.length; i++) {
            System.out.printf("R%d: %d\t", i, registers[i]);
            if ((i + 1) % 8 == 0) System.out.println();
        }
    }
}
