package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// console log heere
		System.out.println("Hello World");

		// String infuraUrl = "https://mainnet.infura.io/v3/YOUR_INFURA_PROJECT_ID";
		// String infuraUrl = "https://eth-mainnet.public.blastapi.io";
		String infuraUrl = "https://jsonrpc.euphoria.aura.network";

        Web3j web3j = Web3j.build(new HttpService(infuraUrl));
        try {
            Web3ClientVersion clientVersion = web3j.web3ClientVersion().send();
            System.out.println("Connected to Ethereum Node: " + clientVersion.getWeb3ClientVersion());
			EthBlockNumber result = new EthBlockNumber();
			result = web3j.ethBlockNumber()
			.sendAsync()
			.get();
			System.err.println(result.getBlockNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
