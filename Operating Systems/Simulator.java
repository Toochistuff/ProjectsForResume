package osSim;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Simulator {
    public static void main(String[] args) {
        // Initialize Memory and CPU
        Memory memory = new Memory();
        CPU cpu = new CPU();
        cpu.memory = memory;

        // Initialize Dispatcher and LTS
        Dispatcher dispatcher = new Dispatcher();
        LTS lts = new LTS(memory);

        // Load jobs from JSON file
        List<Job> jobs = loadJobsFromJson("jobs.json");
        
        //List to store pcbs
        List<PCB> pcbs = new ArrayList<>();


        try {
            cpu.outputWriter = new PrintWriter(new FileWriter("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

     // Load jobs onto the disk
        int diskPointer = 0; // Keep track of where we're writing on the disk

        for (Job job : jobs) {
            PCB pcb = new PCB(job);
            int currentJobID = pcb.getJobID();
            System.out.printf("Simulator: Starting Job %d%n", currentJobID);

            // Reset CPU and memory for the job
            CPU.resetCPU();
            memory.resetMemory();
            lts.resetMemoryPointer(); // Reset RAM pointer before loading the job

            // LTS loads the current job from disk into RAM using PCB
            lts.loadSingleJobFromDisk(pcb);

            // Load process into CPU
            dispatcher.loadProcessToCPU(pcb);

            // **Start Timing**
            long startTime = System.nanoTime();

            // Run the CPU
            while (CPU.running) {
                cpu.fetch();
                if (!cpu.running) break;
                cpu.decode();
                cpu.execute();
            }

            // **End Timing**
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime; // Elapsed time in nanoseconds
            double elapsedTimeInMs = elapsedTime / 1_000_000.0; // Convert to milliseconds

            // Save process state
            dispatcher.saveProcessFromCPU(cpu, pcb);

            // Print memory contents before resetting memory
            printMemoryContents(memory, CPU.outputWriter, pcb, elapsedTimeInMs);

            // Clear job queue for the next job
            lts.resetMemoryPointer();

            System.out.printf("Simulator: Finished processing of Job %d%n", currentJobID);
        }


        // Total number of jobs
        int totalJobs = jobs.size();

        // Reset disk pointer to the beginning for reading
        diskPointer = 0;

        // Process each job one by one
        for (PCB pcb : pcbs) {
            int currentJobID = pcb.getJobID();
            System.out.printf("Simulator: Starting Job %d%n", currentJobID);

            // Reset CPU and memory for the job
            CPU.resetCPU();
            memory.resetMemory();
            lts.resetMemoryPointer(); // Reset RAM pointer before loading the job

            // LTS loads the current job from disk into RAM using PCB
            lts.loadSingleJobFromDisk(pcb);

            // Load process into CPU
            dispatcher.loadProcessToCPU(pcb);

            // **Start Timing**
            long startTime = System.nanoTime();

            // Run the CPU
            while (CPU.running) {
                cpu.fetch();
                if (!cpu.running) break;
                cpu.decode();
                cpu.execute();
            }

            // **End Timing**
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime; // Elapsed time in nanoseconds
            double elapsedTimeInMs = elapsedTime / 1_000_000.0; // Convert to milliseconds

            // Save process state
            dispatcher.saveProcessFromCPU(cpu, pcb);

            // Print memory contents before resetting memory
            printMemoryContents(memory, cpu.outputWriter, pcb, elapsedTimeInMs);

            // Clear job queue for the next job
            lts.clearJobQueue();

            System.out.printf("Simulator: Finished processing of Job %d%n", currentJobID);
        }

        // Close the output writer
        cpu.outputWriter.close();

        System.out.println("All jobs have been processed.");
    }

    // Method to read jobs from JSON file
    public static List<Job> loadJobsFromJson(String filename) {
        List<Job> jobs = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filename);

            // Read JSON file and convert to List<Job>
            jobs = objectMapper.readValue(file, new TypeReference<List<Job>>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public static void printMemoryContents(Memory memory, PrintWriter outputWriter, PCB pcb, double elapsedTimeInMs) {
        outputWriter.println("----------------------------------------------------");
        outputWriter.printf("Memory Contents for Job ID %d:%n", pcb.getJobID());

        // Print Execution Time
        outputWriter.printf("Execution Time: %.3f ms%n", elapsedTimeInMs);

        // Print CPU registers
        outputWriter.println("\nRegisters:");
        for (int i = 0; i < CPU.registers.length; i++) {
            outputWriter.printf("R%d: %d\t", i, CPU.registers[i]);
            if ((i + 1) % 8 == 0) outputWriter.println();
        }

        // Print RAM Instructions
        outputWriter.println("\nRAM Instructions:");
        for (int address = pcb.getCodeStartAddress(); address <= pcb.getCodeEndAddress(); address++) {
            int data = memory.readFromRAM(address);
            outputWriter.printf("RAM[0x%04X]: 0x%08X%n", address, data);
        }

        // Print RAM Data
        outputWriter.println("\nRAM Data:");
        for (int address = pcb.getDataStartAddress(); address <= pcb.getDataEndAddress(); address++) {
            int data = memory.readFromRAM(address);
            if (data != 0) { // Skip zeros if desired
                outputWriter.printf("RAM[0x%04X]: 0x%08X (%d)%n", address, data, data);
            }
        }

        // Print Disk Contents for this job (Code Section)
        outputWriter.println("\nDisk Contents for Job ID " + pcb.getJobID() + " (Code Section):");
        List<String> code = pcb.getJob().getCode();
        for (int i = 0; i < code.size(); i++) {
            outputWriter.printf("Disk[0x%04X]: %s%n", i, code.get(i));
        }

        // Print Disk Contents for this job (Data Section)
        outputWriter.println("\nDisk Contents for Job ID " + pcb.getJobID() + " (Data Section):");
        List<String> dataSection = pcb.getJob().getData();
        for (int i = 0; i < dataSection.size(); i++) {
            String dataString = dataSection.get(i);
            if (!dataString.equals("0x00000000")) {
                outputWriter.printf("Disk[0x%04X]: %s%n", code.size() + i, dataString);
            }
        }

        outputWriter.println("End of Memory Contents");
        outputWriter.println("----------------------------------------------------");
    }



}
