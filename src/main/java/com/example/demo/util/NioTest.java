package com.example.demo.util;

import org.apache.ibatis.annotations.SelectKey;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by lj on 2018/12/27.
 */
public class NioTest {
	public static void FileChannelTest(){
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\Program Files\\springBootdemo\\test.txt", "rws");
			FileChannel channel=randomAccessFile.getChannel();
			RandomAccessFile randomAccessFile1=new RandomAccessFile("E:\\Program Files\\springBootdemo\\test1.txt", "rws");
			FileChannel channel1=randomAccessFile1.getChannel();
			channel.transferTo(channel1.size(),4,channel1);
			channel1.transferFrom(channel,channel1.size(),4);
			ByteBuffer buffer=ByteBuffer.allocate(2);
			System.out.println(channel.position());
			int iread=channel.read(buffer,0);
			while (iread!=-1){
				buffer.flip();
				buffer.clear();
				System.out.println(channel.position());
				iread=channel.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void client(){
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		SocketChannel socketChannel = null;
		try
		{
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));
			if(socketChannel.finishConnect())
			{
				int i=0;
				while(true)
				{
					TimeUnit.SECONDS.sleep(1);
					String info = "I'm "+i+++"-th information from client";
					buffer.clear();
					buffer.put(info.getBytes());
					buffer.flip();
					while(buffer.hasRemaining()){
						System.out.println(buffer);
						socketChannel.write(buffer);
					}
				}
			}
		}
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				if(socketChannel!=null){
					socketChannel.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public static void server(){
		ServerSocket serverSocket = null;
		InputStream in = null;
		try
		{
			serverSocket = new ServerSocket(8080);
			int recvMsgSize = 0;
			byte[] recvBuf = new byte[1024];
			while(true){
				Socket clntSocket = serverSocket.accept();
				SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
				System.out.println("Handling client at "+clientAddress);
				in = clntSocket.getInputStream();
				while((recvMsgSize=in.read(recvBuf))!=-1){
					byte[] temp = new byte[recvMsgSize];
					System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
					System.out.println(new String(temp));
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				if(serverSocket!=null){
					serverSocket.close();
				}
				if(in!=null){
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
     server();
		client();
	}
}
class ServerConnect
{
	private static final int BUF_SIZE=1024;
	private static final int PORT = 8080;
	private static final int TIMEOUT = 3000;
	public static void main(String[] args)
	{
		selector();
	}
	public static void handleAccept(SelectionKey key) throws IOException{
		ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
		SocketChannel sc = ssChannel.accept();
		sc.configureBlocking(false);
		sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocateDirect(BUF_SIZE));
	}
	public static void handleRead(SelectionKey key) throws IOException{
		SocketChannel sc = (SocketChannel)key.channel();
		ByteBuffer buf = (ByteBuffer)key.attachment();
		long bytesRead = sc.read(buf);
		while(bytesRead>0){
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			System.out.println();
			buf.clear();
			bytesRead = sc.read(buf);
		}
		if(bytesRead == -1){
			sc.close();
		}
	}
	public static void handleWrite(SelectionKey key) throws IOException{
		ByteBuffer buf = (ByteBuffer)key.attachment();
		buf.flip();
		SocketChannel sc = (SocketChannel) key.channel();
		while(buf.hasRemaining()){
			sc.write(buf);
		}
		buf.compact();
	}
	public static void selector() {
		Selector selector = null;
		ServerSocketChannel ssc = null;
		try{
			selector = Selector.open();
			ssc= ServerSocketChannel.open();
			ssc.socket().bind(new InetSocketAddress(PORT));
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			while(true){
				if(selector.select(TIMEOUT) == 0){
					System.out.println("==");
					continue;
				}
				Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
				while(iter.hasNext()){
					SelectionKey key = iter.next();
					if(key.isAcceptable()){
						handleAccept(key);
					}
					if(key.isReadable()){
						handleRead(key);
					}
					if(key.isWritable() && key.isValid()){
						handleWrite(key);
					}
					if(key.isConnectable()){
						System.out.println("isConnectable = true");
					}
					iter.remove();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(selector!=null){
					selector.close();
				}
				if(ssc!=null){
					ssc.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}