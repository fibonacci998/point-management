// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract PointManagement {
    address public owner;
    mapping(address => bool) public teachers;
    mapping(address => mapping(string => uint256)) public studentPoints;

    event PointsCreated(address indexed student, string subject, uint256 amount);

    modifier onlyOwner() {
        require(msg.sender == owner, "Only owner can perform this action");
        _;
    }

    modifier onlyTeacher() {
        require(teachers[msg.sender], "Only teacher can perform this action");
        _;
    }

    constructor() {
        owner = msg.sender;
    }

    function addTeacher(address teacher) external onlyOwner {
        teachers[teacher] = true;
    }

    function removeTeacher(address teacher) external onlyOwner {
        teachers[teacher] = false;
    }

    function createPoints(address student, string calldata subject, uint256 point) external onlyTeacher {
        require(student != address(0), "Invalid student address");
        studentPoints[student][subject] += point;
        emit PointsCreated(student, subject, point);
    }

    function getPoints(address student, string calldata subject) external view returns (uint256) {
        return studentPoints[student][subject];
    }
}
