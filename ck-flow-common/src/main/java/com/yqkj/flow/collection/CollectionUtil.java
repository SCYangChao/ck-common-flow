package com.yqkj.flow.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * 
 *
  * @ClassName: CollectionUtil
  * @Description: 
  * @author yangchao.coo@gmail.com
  * @date 2019年5月16日 下午5:49:37
  *
 */
public class CollectionUtil {

	private static List EMPTY_LIST = new ArrayList<>(1);
	
	private static Set EMPTY_SET = new HashSet();

	
	private static Map EMPTY_MAP = new HashMap<>(1);

	/**
	 *
	 * @param str
	 * @return
	 */
	public  static  List<String> splitToList(String str ) {

		if (StringUtils.isBlank(str)) {

			return EMPTY_LIST;

		}

		return Arrays.asList(str.split(","));

	}
	
	
	/**
	  * @Description: 
	  * @param list
	  * @param group
	  * @return Map<K,List<O>>
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年6月13日 上午9:31:30
	 */
    public static <K, O >  Map<K , List<O>> groupList(List<O> list , Function<O , K> group){
        if (null == list) {
            return  new HashMap<>();
        }
        return  list.stream().collect(Collectors.groupingBy(group));
    }
	/**
	 * 求平均值
	  * 
	  * @Description: 
	  * @param list
	  * @param fn
	  * @return Double
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年6月11日 下午4:55:09
	 */
	public static <T , R> Double avgDouble(List<T> list , ToDoubleFunction<T> fn) {
		
		if (isNull(list)) {
			
			return 0D;
			
		}
		
		return list.stream().mapToDouble(fn).average().getAsDouble();
	} 
	
	/**
	 * 
	  * 
	  * @Description: 
	  * @param ids
	  * @return List<Long>
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年6月11日 上午10:51:15
	 */
	public static List<Long> parseIds(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			
			String[] ar = ids.split(",");
			
			List<Long> result = new ArrayList<>(ar.length);
			
			for (String n : ar) {
				
				try {
					if (StringUtils.isNotBlank(n)) {
						
						result.add(Long.valueOf(n));
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return result;
			
		}
		return null;
		
	}

	/**
	  * @Description: 
	  * @param list
	  * @param fn
	  *  @return
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年6月10日 上午10:09:39
	 */
	public static <T , K, V , R>  void excuteMethod(List<T> list ,Function<T, R> fn) {
		
		if (isNull(list)) {
			
			return ;
			
		}
		
		list.forEach(ob -> {
			
			fn.apply(ob);
			
		});
		
	}
	
	 /**
     * 跟一个值另一个值
     * @param list
     * @param fn
     * @param consumer
     * @param map
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public  static <T,K,V> List<T> initOneInfo(List<T> list , Function<T , K> fn , Function<T , Consumer<V>> consumer, Map<K , V> map) {

        if (null == list || null == map) {
            return list;
        }
        for (T t : list) {

            K key = fn.apply(t);

            if (map.containsKey(key)) {

               V value =  map.get(key);

               consumer.apply(t).accept(value);

            } else {
            	
            	V value =  null;

                consumer.apply(t).accept(value);

            	
            }

        }
        return list;

    }
	/**
	 * 过滤数据
	  * 
	  * @Description: 
	  * @param list
	  * @param pre
	  * @return List<T>
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年6月4日 上午10:21:24
	 */
	public  static <T> List<T> filterList(List<T> list , Predicate<T> pre) {
		if (isNull(list)) {
			return EMPTY_LIST;
		}
		return list.stream().filter(pre).collect(Collectors.toList());
	}
	
	
	/** 
	  * @Description:检查数组是否为空 如果为空则返回空集合 
	  * @param list
	  * @return List<T>
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年5月28日 下午5:00:34
	 */
	public  static <T> List<T> checkListAndReturnEmptyList(List<T> list) {
		if (isNull(list)) {
			return EMPTY_LIST;
		}
		return list;
	}

 /**
  * 
  * @Description: 
  * @param list
  * @param fn
  * @return Double
  * @exception:
  * @throws
  * @author: yangchao.coo@gmail.com
  * @time:2019年5月27日 上午10:35:12
 */
public static <T> Double sumDouble(List<T> list , Function<T, Double> fn) {
		
		if (isNull(list)) {
			
			return Double.valueOf(0);
			
		}
		
        return list.stream().map(fn).reduce(Double::sum).get();
		
	}
	/**
	 * 
	  * 
	  * @Description: list集合求和
	  * @param list
	  * @param fn
	  * @return Integer
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年5月27日 上午10:33:21
	 */
	public static <T> Integer sumInteger(List<T> list , Function<T, Integer> fn) {
		
		if (isNull(list)) {
			
			return Integer.valueOf(0);
			
		}
		
		List<Integer> longList = list.stream().map(fn).filter(num -> null != num).collect(Collectors.toList());
		
        return longList.stream().reduce(Integer::sum).get();
		
	}
	/**
	 * 
	  * 
	  * @Description: 
	  * @param list
	  * @return List<T>
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年5月27日 上午10:28:46
	 */
	public static <T> List<T> listRever(List<T> list) {
		
		if (isNull(list)) {
			
			return EMPTY_LIST;
			
		}
		List<T> result = new ArrayList<>(list.size());
		
		for (int index = result.size() ;index>0 ; ++ index) {
			result.add(list.get(index));
		}
		
		return result;
	}



	/**
	  * 降序
	  * @Description: 
	  * @param list
	  * @param cm void
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年5月22日 上午9:28:33
	 */
	public static <O> void sortDesc(List<O> list ,  Comparator<O> cm) {
		if (null == cm) {
			return;
		}
		sort(list , cm.reversed());
	  }
	/**
	  * 降序
	  * @Description: 
	  * @param list
	  * @param cm void
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年5月22日 上午9:28:33
	 */
	public static <O> void sort(List<O> list ,  Comparator<O> cm) {
		
		if (Objects.isNull(list) || list.isEmpty()) {
			return ;
		}
		list.stream().sorted(cm);
		
	}
	/**
     *  利用方法<T>
     * List<Object> 转换成Map<String , Object>
     * @param list
     * @param <K>
     * @param <T>
     * @return
     */
    public static  <K , T , V> Map<K , V> convertMap( Set<T> list , Function<T , K> keyFn , Function<T , V> valueFn) {
    	
        Map<K , V> result = new HashMap<>(list.size());

        if (null == list || list.isEmpty()) {

            return  EMPTY_MAP;

        }

        for (T ob : list ) {

            result.put(keyFn.apply(ob) ,valueFn.apply(ob));

        }

        return  result;

    }
	/**
     *  利用方法<T>
     * List<Object> 转换成Map<String , Object>
     * @param list
     * @param <K>
     * @param <T>
     * @return
     */
    public static  <K , T , V> Map<K , V> convertMap( List<T> list , Function<T , K> keyFn , Function<T , V> valueFn) {
    	
        Map<K , V> result = new HashMap<>(list.size());

        if (null == list || list.isEmpty()) {

            return  EMPTY_MAP;

        }

        for (T ob : list ) {

            result.put(keyFn.apply(ob) ,valueFn.apply(ob));

        }

        return  result;

    }
    /**
     * 列表转为另一个列表
     * @param list
     * @param fn
     * @param <T>
     * @param <R>
     * @return
     */
    public  static  <T , R> Set<R> convertToSet(List<T> list , Function<T , R> fn) {
    	if (Objects.isNull(list) || list.isEmpty()) {
    		return EMPTY_SET;
    	}
    	
    	Set<R> resutlt = new HashSet<>(list.size());
    	
    	for (T t : list ) {
    		
    		resutlt.add(fn.apply(t));
    		
    	}
    	
        return  resutlt;
    }
    /**
     * 列表转为另一个列表
     * @param list
     * @param fn
     * @param <T>
     * @param <R>
     * @return
     */
    public  static  <T , R> List<R> convertToList(Set<T> list , Function<T , R> fn) {
    	if (Objects.isNull(list) || list.isEmpty()) {
    		return EMPTY_LIST;
    	}
        return  list.stream().map(fn).collect(Collectors.toList());
    }
    /**
     * 列表转为另一个列表
     * @param list
     * @param fn
     * @param <T>
     * @param <R>
     * @return
     */
    public  static  <T , R> List<R> convertToList(List<T> list , Function<T , R> fn) {
    	if (Objects.isNull(list) || list.isEmpty()) {
    		return EMPTY_LIST;
    	}
        return  list.stream().map(fn).collect(Collectors.toList());
    }

	/**
	 * 集合非空
	 * @param t
	 * @param <T>
	 * @return
	 */
    public  static <T> Boolean isNotNull(List<T> t) {
    	return  !isNull(t);
	}

	/**
	 * 数组是否为空
	 * @param t
	 * @param <T>
	 * @return
	 */
	public  static<T>  Boolean isNull(Long[] t) {

		if (null == t || t.length<=0) {
			return  Boolean.TRUE;
		}

		return Boolean.FALSE;

	}
	
	/**
	 *
	  * class_name: CollectionUtil
	  * describe: do
	  * @author: yangchao.cool@gmail.com
	  * creat_date: 上午10:05
	  *
	 **/
    public  static<T>  Boolean isNull(List<T> t) {

        if (null == t || t.isEmpty()) {
            return  Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

}
