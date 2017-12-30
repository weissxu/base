package base.mapper;

/**
 * 
 * @author siwei
 *
 * @param <E>
 */
public interface BaseMapper<E> {
	/**
	 * 根据id查实体
	 * @param id
	 * @return
	 */
	E findById(Long id);

	/**
	 * 根据id删除实体
	 * @param id
	 */
	void delelte(Long id);

	/**
	 * 插入一条记录
	 * @param entity
	 */
	void insert(E entity);

	/**
	 * 更新一条记录
	 * @param entity
	 */
	void update(E entity);
}
