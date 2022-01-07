package it.frogject;

import it.frogject.domain.Resource;
import it.frogject.dto.ResourceDTO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class FrogjectApplication {
	@Bean
	public ModelMapper modelMapper() {
		Converter<Date, LocalDate> sqlDateToLocalDate = new AbstractConverter<Date, LocalDate>() {
			@Override
			protected LocalDate convert(Date source) {
				LocalDate localDate = source.toLocalDate();
				return localDate;
			}
		};
		Converter<LocalDate , Date> localDateToSqlDateTo = new AbstractConverter<LocalDate , Date>() {
			@Override
			protected Date convert(LocalDate source) {
				Date localDate = Date.valueOf(source);
				return localDate;
			}
		};
		Converter<Resource, ResourceDTO> populateResource = new Converter<Resource, ResourceDTO>() {

			@Override
			public ResourceDTO convert(MappingContext<Resource, ResourceDTO> context) {
				context.getDestination().setId(context.getSource().getId());
				context.getDestination().setName(context.getSource().getName());
				context.getDestination().setSurname(context.getSource().getSurname());

				return context.getDestination();
			}
		};

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(sqlDateToLocalDate);
		modelMapper.addConverter(localDateToSqlDateTo);
		modelMapper.addConverter(populateResource);
		return modelMapper;
	}
	public static void main(String[] args) {
		SpringApplication.run(FrogjectApplication.class, args);
	}

}
