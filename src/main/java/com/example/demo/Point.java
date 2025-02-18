package com.example.demo;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.6.2.
 */
@SuppressWarnings("rawtypes")
public class Point extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_ADDTEACHER = "addTeacher";

    public static final String FUNC_CREATEPOINTS = "createPoints";

    public static final String FUNC_GETPOINTS = "getPoints";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_REMOVETEACHER = "removeTeacher";

    public static final String FUNC_STUDENTPOINTS = "studentPoints";

    public static final String FUNC_TEACHERS = "teachers";

    public static final Event POINTSCREATED_EVENT = new Event("PointsCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Point(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Point(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Point(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Point(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<PointsCreatedEventResponse> getPointsCreatedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(POINTSCREATED_EVENT, transactionReceipt);
        ArrayList<PointsCreatedEventResponse> responses = new ArrayList<PointsCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PointsCreatedEventResponse typedResponse = new PointsCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.student = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static PointsCreatedEventResponse getPointsCreatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(POINTSCREATED_EVENT, log);
        PointsCreatedEventResponse typedResponse = new PointsCreatedEventResponse();
        typedResponse.log = log;
        typedResponse.student = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<PointsCreatedEventResponse> pointsCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getPointsCreatedEventFromLog(log));
    }

    public Flowable<PointsCreatedEventResponse> pointsCreatedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(POINTSCREATED_EVENT));
        return pointsCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addTeacher(String teacher) {
        final Function function = new Function(
                FUNC_ADDTEACHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, teacher)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createPoints(String student, String subject,
            BigInteger point) {
        final Function function = new Function(
                FUNC_CREATEPOINTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, student), 
                new org.web3j.abi.datatypes.Utf8String(subject), 
                new org.web3j.abi.datatypes.generated.Uint256(point)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getPoints(String student, String subject) {
        final Function function = new Function(FUNC_GETPOINTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, student), 
                new org.web3j.abi.datatypes.Utf8String(subject)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> removeTeacher(String teacher) {
        final Function function = new Function(
                FUNC_REMOVETEACHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, teacher)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> studentPoints(String param0, String param1) {
        final Function function = new Function(FUNC_STUDENTPOINTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.Utf8String(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> teachers(String param0) {
        final Function function = new Function(FUNC_TEACHERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static Point load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Point(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Point load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Point(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Point load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Point(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Point load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Point(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class PointsCreatedEventResponse extends BaseEventResponse {
        public String student;

        public String subject;

        public BigInteger amount;
    }
}
