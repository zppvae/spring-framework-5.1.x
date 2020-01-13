package org.zpp.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author zpp
 * @date 2020/1/13 14:00
 */
public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;

	/**
	 * getBean("beanName")时会调用此方法返回结果
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] carInfos = carInfo.split(",");
		car.setBrand(carInfos[0]);
		car.setMaxSpeed(Integer.valueOf(carInfos[1]));
		car.setPrice(Double.valueOf(carInfos[2]));
		return car;
	}

	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
}
