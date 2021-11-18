package course.automation.model;

import java.util.Objects;

public class FormForCalculator {
    private String numberOfInstances;
    private String operationSystem;
    private String machineClass;
    private String instanceType;
    private String instanceSeries;
    private String numberOfGPUs;
    private String GPUType;
    private String localSSD;
    private String location;
    private String commitedUsage;

    public FormForCalculator(String numberOfInstances, String operationSystem, String machineClass,
                             String instanceType, String instanceSeries, String numberOfGPUs, String GPUType,
                             String localSSD, String location, String commitedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
        this.machineClass = machineClass;
        this.instanceType = instanceType;
        this.instanceSeries = instanceSeries;
        this.numberOfGPUs = numberOfGPUs;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.location = location;
        this.commitedUsage = commitedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getInstanceSeries() {
        return instanceSeries;
    }

    public void setInstanceSeries(String instanceSeries) {
        this.instanceSeries = instanceSeries;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    @Override
    public String toString() {
        return "FormForCalculator{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operationSystem='" + operationSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", instanceSeries='" + instanceSeries + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", location='" + location + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormForCalculator that = (FormForCalculator) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operationSystem, that.operationSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(instanceSeries, that.instanceSeries) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(GPUType, that.GPUType) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(location, that.location) &&
                Objects.equals(commitedUsage, that.commitedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operationSystem, machineClass, instanceType,
                instanceSeries, numberOfGPUs, GPUType, localSSD, location, commitedUsage);
    }
}
