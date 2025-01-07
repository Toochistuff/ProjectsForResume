package osSim;

import java.util.ArrayList;
import java.util.List;

public class LTS {
    private Memory memory;
    private int memoryPointer = 0; // Pointer for writing into RAM
    private List<PCB> jobQueue = new ArrayList<>();

    public LTS(Memory memory) {
        this.memory = memory;
    }

    public void resetMemoryPointer() {
        this.memoryPointer = 0;
    }

    public void loadSingleJobFromDisk(PCB pcb) {
        int diskPointer = pcb.getDiskStartAddress();

        System.out.printf("LTS: Loading Job %d from disk into RAM.%n", pcb.getJobID());

        // Read job instructions from disk
        List<Integer> jobInstructions = new ArrayList<>();
        int instruction;
        while ((instruction = memory.readFromDisk(diskPointer++)) != 0xFFFFFFFF) {
            jobInstructions.add(instruction);
        }

        // Read job data from disk (if applicable)
        // For now, we're assuming there's no data segment
        // You can add data segment handling here if needed

        // Write instructions to RAM
        int startAddress = memoryPointer;
        for (int instr : jobInstructions) {
            memory.writeToRAM(memoryPointer++, instr);
        }
        int endAddress = memoryPointer - 1;

        // Update PCB with RAM addresses
        pcb.setStartAddress(startAddress);
        pcb.setEndAddress(endAddress);
        pcb.setProgramCounter(startAddress);


        // Add PCB to job queue
        jobQueue.add(pcb);

        System.out.printf("LTS: Job %d loaded into RAM addresses 0x%X to 0x%X.%n", pcb.getJobID(), startAddress, endAddress);
    }



    public List<PCB> getJobQueue() {
        return jobQueue;
    }

    public void clearJobQueue() {
        jobQueue.clear();
    }
}
