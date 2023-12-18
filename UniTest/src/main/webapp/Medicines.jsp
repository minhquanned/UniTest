<%@page import="com.java.be.Medicine"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
<title>Medicines List</title>
</head>
<body>
	<section class="vh-100 bg-secondary bg-gradient gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 text-center">
								<button type="button"
									class="btn btn-danger btn-rounded btn-sm my-0"
									onclick="location.href='/UniTest'">
									<i class="fa-solid fa-chevron-left"></i>
								</button>
								Medicines List
							</h3>

							<div class="mt-4 pt-2">
								<button type="button"
									class="btn btn-primary btn-rounded btn-sm my-0"
									onclick="location.href='SubjectRegistration.jsp'">
									<i class="fa-solid fa-plus"></i>&nbsp;&nbsp;Add
								</button>
							</div>
							<br>

							<form class="d-flex justify-content-md-around">

								<table class="table ccard-table table-striped table-hover">
									<tr>
										<th>Medicine ID</th>
										<th>Medicine Name</th>
										<th>Function</th>
										<th class="text-center" colspan="3"></th>
									</tr>

									<c:forEach var="item" items="${ListMedicines}">

										<tr>
											<td>${item.getMedicineID()}</td>
											<td>${item.getMedicineName()}</td>
											<td>${item.getMedicineFunction()}</td>
											<td><span class="table-remove edit">
													<button type="button"
														class="btn btn-primary btn-rounded btn-sm my-0"
														onclick="moreInfo('${item.getMedicineID()}','${item.getMedicineName()}','${item.getMedicineFunction()}', '${item.getUnit()}', '${item.getDoseMin()}', '${item.getDoseMax()}')">More
														Info</button>
											</span></td>
											<td><span>
													<button type="button"
														class="btn btn-primary btn-rounded btn-sm my-0"
														onclick="location.href='/LTW_final/EditSubject?subjectID=${item.getMedicineID()}'">
														Prescription</button>
											</span></td>
											<td><span class="table-remove edit">
													<button type="button"
														class="btn btn-danger btn-rounded btn-sm my-0"
														onclick="location.href='/LTW_final/DeleteSubject?subjectID=${item.getMedicineID()}'">
														Remove</button>
											</span></td>
										</tr>

									</c:forEach>

									<script type="text/javascript">
										function moreInfo(medicineID, medicineName, medicineFunction, unit, doseMin, doseMax) {
											alert("Subject ID: " + medicineID
													+ "\nSubject Name: " + medicineName
													+ "\nNumber of credits: " + medicineFunction
													+ "\nNumber of credits: " + unit
													+ "\nMinimum dose: " + doseMin
													+ "\nMaximim dose: " + doseMax);
										}
									</script>

								</table>



							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>