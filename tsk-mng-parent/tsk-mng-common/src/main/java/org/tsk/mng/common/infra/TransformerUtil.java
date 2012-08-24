package org.tsk.mng.common.infra;


import org.dozer.Mapper;
import org.tsk.mng.common.config.Consts;

public class TransformerUtil {

	private static Mapper mapper;

	/**
	 * Converts object type K to object type T.
	 * Converted classes need to be mapped in dozer 
	 * @param fromObj - object that we convert him 
	 * @param toObjClass - class of the object that we convert to
	 * @return converted object
	 */
	public static <T, K> T dozerConvert(K fromObj, Class<T> toObjClass) {

		mapper = SpringInitializer.getBeanFactory().getBean(Consts.MAPPER_BEAN ,Mapper.class);
		T toObj = mapper.map(fromObj, toObjClass);

		return toObj;
	}
	
}
