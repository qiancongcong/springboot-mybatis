package cc.Test;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.RawTransaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TransactionTest2 {
    public static void main(String[] args) throws Exception {
        //调用的是kovan测试环境，这里使用的是infura这个客户端
       /* Web3j web3j = Web3j.build(new HttpService("https://kovan.infura.io/<your-token>"));
        //转账人账户地址
        String ownAddress = "0xD1c82c71cC567d63Fd53D5B91dcAC6156E5B96B3";
        //被转人账户地址
        String toAddress = "0x6e27727bbb9f0140024a62822f013385f4194999";
        //转账人私钥
        Credentials credentials = Credentials.create("xxxxxxxx");

        TransactionReceipt transactionReceipt;
        transactionReceipt = Transfer.sendFunds(
                web3j, credentials, toAddress,
                BigDecimal.valueOf(0.2), Convert.Unit.ETHER).send();

        System.out.println(transactionReceipt.getTransactionHash());*/
        /*Web3j web3 = Web3j.build(new HttpService("https://kovan.infura.io/yXDUNwlNOcx0UJCWjzNr"));
                 Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
                 String clientVersion = web3ClientVersion.getWeb3ClientVersion();
                 System.out.println(clientVersion);*/

                //设置需要的矿工费
                 BigInteger GAS_PRICE = BigInteger.valueOf(22_000_000_000L);
                 BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000);

                 //调用的是kovan测试环境，这里使用的是infura这个客户端
                 Web3j web3j = Web3j.build(new HttpService("https://kovan.infura.io/<your-token>"));
                 //转账人账户地址
                 String ownAddress = "0xD1c82c71cC567d63Fd53D5B91dcAC6156E5B96B3";
                 //被转人账户地址
                 String toAddress = "0x6e27727bbb9f0140024a62822f013385f4194999";
                 //转账人私钥
                 Credentials credentials = Credentials.create("xxxxxxxxxxxxx");
                 //        Credentials credentials = WalletUtils.loadCredentials(
                 //                "123",
                //                "src/main/resources/UTC--2018-03-01T05-53-37.043Z--d1c82c71cc567d63fd53d5b91dcac6156e5b96b3");

                 //getNonce（这里的Nonce我也不是很明白，大概是交易的笔数吧）
                 EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                                 ownAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
                 BigInteger nonce = ethGetTransactionCount.getTransactionCount();

                //创建交易，这里是转0.5个以太币
                 BigInteger value = Convert.toWei("0.5", Convert.Unit.ETHER).toBigInteger();
                 RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                                nonce, GAS_PRICE, GAS_LIMIT, toAddress, value);

                 //签名Transaction，这里要对交易做签名
                 byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
                 String hexValue = Numeric.toHexString(signedMessage);

                //发送交易
                EthSendTransaction ethSendTransaction =
                                 web3j.ethSendRawTransaction(hexValue).sendAsync().get();
                 String transactionHash = ethSendTransaction.getTransactionHash();

                 //获得到transactionHash后就可以到以太坊的网站上查询这笔交易的状态了
                 System.out.println(transactionHash);

             }




}
