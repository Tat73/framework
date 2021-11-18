package course.automation.service;

import course.automation.model.FormForCalculator;

public class FormForCalculatorCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.formForCalculator.numberOfInstances";
    public static final String TESTDATA_OPERATION_SYSTEM = "testdata.formForCalculator.operationSystem";
    public static final String TESTDATA_MACHINE_CLASS = "testdata.formForCalculator.machineClass";
    public static final String TESTDATA_INSTANCE_TYPE = "testdata.formForCalculator.instanceType";
    public static final String TESTDATA_INSTANCE_SERIES = "testdata.formForCalculator.instanceSeries";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.formForCalculator.numberOfGPUs";
    public static final String TESTDATA_GPU_TYPE = "testdata.formForCalculator.GPUType";
    public static final String TESTDATA_LOCAL_SSD = "testdata.formForCalculator.localSSD";
    public static final String TESTDATA_LOCATION = "testdata.formForCalculator.location";
    public static final String TESTDATA_COMMITED_USAGE = "testdata.formForCalculator.commitedUsage";

    public static FormForCalculator withCredentialsFromProperty() {
        return new FormForCalculator(
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATION_SYSTEM),
                TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE),
                TestDataReader.getTestData(TESTDATA_INSTANCE_SERIES),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITED_USAGE));
    }
}
