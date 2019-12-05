package com.bridgelabz.cliniquemanagement.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.cliniquemanagement.controller.ClinicController;
import com.bridgelabz.cliniquemanagement.model.DoctorDetails;
import com.bridgelabz.cliniquemanagement.model.PatientDetails;
import com.bridgelabz.cliniquemanagement.repository.CliniqueRepository;
import com.bridgelabz.cliniquemanagement.utility.Utility;

public class CliniqueServiceImpl implements CliniqueService {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		static String doctor = "JsonFile/doctor.json";
		static String patient = "JsonFile/patient.json";
		static String appointment = "JsonFile/appointment.json";

		@SuppressWarnings("unchecked")
		@Override
		public void doctorDetails() {

			jsonArray = CliniqueRepository.readData(doctor);

			DoctorDetails doctorDetails = new DoctorDetails();
			System.out.println("Enter Doctor Name");
			String doctorName = Utility.inputString();
			if (Utility.isStringOnlyAlphabet(doctorName)) {
				doctorDetails.setDoctorName(doctorName);
			}

			System.out.println("Enter Doctor Specialization");
			String specialization = Utility.inputString();
			if (Utility.isStringOnlyAlphabet(specialization)) {
				doctorDetails.setSpecialization(specialization);
			}

			System.out.println("Enter Doctor Availability");
			String availability = Utility.inputString();
			if (Utility.isStringOnlyAlphabet(availability)) {
				doctorDetails.setAvailability(availability);
			}

			doctorDetails.setDoctorId(Utility.doctorId());
			doctorDetails.setNumberOfPatients(0);

			jsonObject.put("Id", doctorDetails.getDoctorId());
			jsonObject.put("Name", doctorDetails.getDoctorName());
			jsonObject.put("Specialization", doctorDetails.getSpecialization());
			jsonObject.put("Availability", doctorDetails.getAvailability());
			jsonObject.put("Patients", doctorDetails.getNumberOfPatients());

			jsonArray.add(jsonObject);

			System.out.println(jsonArray);
			CliniqueRepository.writeData(doctor, jsonArray);

		}


		/** Reads doctor's data from json file **/
<<<<<<< HEAD
		@SuppressWarnings("rawtypes")
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
		@Override
		public void readDoctorData(String key, String value,String choice) {
			
				//	adds json data to json array
				jsonArray = (JSONArray) CliniqueRepository.readData(doctor);
				//	iterator to iterate json data
				Iterator iterator = jsonArray.iterator();
				//	json objects top store json data from array
				JSONObject jsonObject, lastJasonObject = null;
				
				//	iterates over json array
				while (iterator.hasNext()) {
					//	checks if data given by user matches with any json object
					//	and if present prints it
					if ((jsonObject = (JSONObject) iterator.next()).get(key).equals(value)) {
						lastJasonObject = jsonObject;
						System.out.println("\nDoctor Information:");
						System.out.println("ID: " + jsonObject.get("Id") + "\t");
						System.out.println("Name: " + jsonObject.get("Name") + "\t");
						System.out.println("Specialization: " + jsonObject.get("Specialization") + "\t");
						System.out.println("Availability: " + jsonObject.get("Availability") + "\t");
						System.out.println("Number of Patients: " + jsonObject.get("Patients") + "\n");
						
						//asks user if want to take an appointment
						System.out.println("Do you want to take an appointment?[y/n]");
						String response = Utility.inputString().toLowerCase();
						if (response.equals("y")) {
							makeAppointment(lastJasonObject);
						}
						else {
							ClinicController.menu();
						}
					}
				}
				System.out.println("Enter valid Doctor "+key);
				ClinicController.doctorChoice(choice);
		}

		@SuppressWarnings("unchecked")
		private void makeAppointment(JSONObject doctorJsonObject) {
			String patientId = "";
			String doctorId = (String) doctorJsonObject.get("Id");
			long patients = (long) doctorJsonObject.get("Patients");
			if (patients >= 5) { // doctor is busy
				System.out.println("Sorry!!! Doctor is busy today. Do you want to take an appointment tomorrow[y/n]");
				//current date
			      LocalDate today = LocalDate.now();
				  
				//adding one day to the localdate
				LocalDate tomorrow = today.plusDays(1);
				DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy");   
			    
			    String date = tomorrow.format(format); 
				  
				//System.out.println("Tomorrow's Date: "+dateTime);
				String response = Utility.inputString().toString();
				if(response.equals("y")) {
<<<<<<< HEAD
					@SuppressWarnings("unused")
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
					int count = 0;
					JSONArray jsonArray = CliniqueRepository.readData(appointment);
					JSONObject jsonObject = new JSONObject();
					patientId = Utility.patientId(); 
					jsonObject.put("DoctorId", doctorId);
					jsonObject.put("PatientId", patientId);
					jsonObject.put("AppointmentDate", date);
					//jsonObject.put("Total Patient", count++);
					
					jsonArray.add(jsonObject);
					
					CliniqueRepository.writeData(appointment, jsonArray);
					System.out.println("Congratulation You got an appointment on "+date+". Your Patient ID is " + patientId + "\n");
					ClinicController.menu();
				}
				else {
					ClinicController.menu();
				}
				
				
			} 
			// doctor is not busy. Increases number of patients and updates json file
			else { 
				patientId = Utility.patientId(); 
				// updates patient json file
				patientDetailsNew(patientId,doctorId);
				doctorJsonObject.put("Patients", patients+1);
				updateDoctorData(doctorJsonObject);
				System.out.println("Congratulation You got an appointment. Your Patient ID is " + patientId + "\n");
				ClinicController.menu();
			}

		}

<<<<<<< HEAD
		@SuppressWarnings({ "rawtypes", "unchecked" })
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
		private void updateDoctorData(JSONObject doctorJsonObject) {

			jsonArray = CliniqueRepository.readData(doctor);

			JSONArray updatedArray = new JSONArray(); // new array with updated elements
			Iterator iterator = jsonArray.iterator();

			// iterates over array
			while (iterator.hasNext()) {
				JSONObject object = (JSONObject) iterator.next();
				if (object.get("Id").equals(doctorJsonObject.get("Id"))) {
					updatedArray.add(doctorJsonObject);
				} else {
					updatedArray.add(object);
				}
			}

			CliniqueRepository.writeData(doctor, updatedArray);

		}

		@SuppressWarnings("unchecked")
		public void patientDetailsNew(String id, String doctorId) {

			JSONArray jsonArray = CliniqueRepository.readData(patient);

			PatientDetails patientDetails = new PatientDetails();
			System.out.println("Enter Patient Name");
			String patientName = Utility.inputString();
			if (Utility.isStringOnlyAlphabet(patientName)) {
				patientDetails.setPatientName(patientName);
			}

			System.out.println("Enter Mobile Number");
			String mobile = Utility.inputString();
			if (Utility.mobileNumberValidator(mobile)) {
				System.out.println("Mobile :" + mobile);
				patientDetails.setMobile(Long.parseLong(mobile));
			}

			System.out.println("Enter Age");
			int age = Utility.inputInteger();
			patientDetails.setAge(age);

			patientDetails.setId(Utility.patientId());

			jsonObject.put("Id", patientDetails.getId());
			jsonObject.put("Name", patientDetails.getPatientName());
			jsonObject.put("Mobile", patientDetails.getMobile());
			jsonObject.put("Age", patientDetails.getAge());
			jsonObject.put("Doctor Id",doctorId);

			jsonArray.add(jsonObject);
			//System.out.println(jsonArray);
			CliniqueRepository.writeData(patient, jsonArray);
		}

<<<<<<< HEAD
		@SuppressWarnings("rawtypes")
=======
>>>>>>> 079dd10ffc630928093a85722a6f4a3c02fa35b6
		@Override
		public void readPatientData(String key, String value) {
			jsonArray = CliniqueRepository.readData(patient);
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject;
			while (iterator.hasNext()) {
				if ((jsonObject = (JSONObject) iterator.next()).containsValue(value)) {
					System.out.println("\nPatient Information:");
					System.out.println("ID: " + jsonObject.get("Id") + "\t");
					System.out.println("Name: " + jsonObject.get("Name") + "\t");
					System.out.println("Mobile Number: " + jsonObject.get("Mobile") + "\t");
					System.out.println("Age: " + jsonObject.get("Age") + "\n");
				}
			}
			ClinicController.menu();
		}

}
