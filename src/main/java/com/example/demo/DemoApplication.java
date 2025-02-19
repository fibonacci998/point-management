package com.example.demo;

import java.math.BigInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// console log heere
		System.out.println("Hello World");

		// String infuraUrl = "https://mainnet.infura.io/v3/YOUR_INFURA_PROJECT_ID";
		// String infuraUrl = "https://eth-mainnet.public.blastapi.io";
		String rpc = "https://jsonrpc.euphoria.aura.network";

		String privateKey = "562a7583e538b39cc3b43b6e6f9b9a1230e12dee5b8b104d1ab8d4d84199ae57";
		String contractAddress = "0xCfEc2a7147413985eD1DD8064c2763165FB93d04";
		Credentials credentials = Credentials.create(privateKey);
		ContractGasProvider contractGasProvider = new DefaultGasProvider();
        Web3j web3j = Web3j.build(new HttpService(rpc));
		Point contract = Point.load(
			contractAddress, 
			web3j, 
			credentials, 
			contractGasProvider
		);

        try {
            Web3ClientVersion clientVersion = web3j.web3ClientVersion().send();
            System.out.println("Connected to Ethereum Node: " + clientVersion.getWeb3ClientVersion());
			EthBlockNumber result = new EthBlockNumber();
			result = web3j.ethBlockNumber()
			.sendAsync()
			.get();
			System.err.println(result.getBlockNumber());

			BigInteger studentPoint = contract.getPoints("0x51994393C4D23e2c245E7896289abeF9590F71a9", "math").send();

			System.out.println("Student point: " + studentPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
