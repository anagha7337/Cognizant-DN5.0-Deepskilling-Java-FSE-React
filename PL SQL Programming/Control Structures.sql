-- QUERIES TO CREATE TABLES
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    DOB DATE,
    Balance NUMBER,
    IsVIP CHAR(1)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


-- QUERIES TO INSERT VALUES
INSERT INTO Customers VALUES
(1, 'Anil', DATE '1955-04-15', 15000, 'N');

INSERT INTO Customers VALUES
(2, 'Rahul', DATE '1995-08-20', 8000, 'N');

INSERT INTO Customers VALUES
(3, 'Priya', DATE '1960-02-10', 12000, 'N');

INSERT INTO Loans VALUES
(101, 1, 9.5, SYSDATE + 15);

INSERT INTO Loans VALUES
(102, 2, 10.0, SYSDATE + 45);

INSERT INTO Loans VALUES
(103, 3, 8.5, SYSDATE + 25);

COMMIT;


-- SCENARIO 1
DECLARE
    CURSOR cust_cur IS
        SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID;
    
    v_age NUMBER;
BEGIN
    FOR rec IN cust_cur LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB)/12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');
END;
/


-- SCENARIO 2
DECLARE
    CURSOR cust_cur IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR rec IN cust_cur LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');
END;
/


-- SCENARIO 3
DECLARE
    CURSOR loan_cur IS
        SELECT c.Name, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN loan_cur LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || rec.Name ||
            ', your Loan ID ' || rec.LoanID ||
            ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/