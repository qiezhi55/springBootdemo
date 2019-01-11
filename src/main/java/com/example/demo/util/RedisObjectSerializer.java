package com.example.demo.util;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.*;

import static org.springframework.util.ObjectUtils.isEmpty;


/**
 * Created by lj on 2018/12/18.
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {
	static final byte[] EMPTY_ARRAY = new byte[0];

	@Override
	public byte[] serialize(Object o) throws SerializationException {
		if (o==null)return EMPTY_ARRAY;
		ObjectOutputStream obi=null;
		ByteArrayOutputStream bai=null;
		try {
			bai =new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(o);
			byte[] byt = bai.toByteArray();
			return byt;
		}catch (IOException  e){
			e.printStackTrace();
			return EMPTY_ARRAY;
		}
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (isEmpty(bytes)) return null;
		ObjectInputStream objectInputStream=null;
		ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
		try{
			objectInputStream=new ObjectInputStream(byteArrayInputStream);
			Object object=objectInputStream.readObject();
			return object;
		}catch (Exception  e){
			e.printStackTrace();
		}
		return null;
	}
}
