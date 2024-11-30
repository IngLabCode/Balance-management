-- Insert Users
INSERT INTO users (id, firstname, lastname, email, password, verified, otp, otp_expiry, is_enabled)
VALUES
    (1, 'John', 'Doe', 'john.doe@example.com', 'password123', true, NULL, NULL, true),
    (2, 'Jane', 'Smith', 'jane.smith@example.com', 'securePass456', true, NULL, NULL, true);

-- Insert Roles for the Users
INSERT INTO authorities (user_id, role)
VALUES
    (1, 'USER'),
    (2, 'ADMIN');

-- Insert Expense Categories
INSERT INTO expense_category (id, name, description, user_id)
VALUES
    (1, 'Food', 'Food-related expenses', 1),
    (2, 'Transport', 'Transportation expenses', 2);

-- Insert Income Categories
INSERT INTO income_category (id, name, description, user_id)
VALUES
    (1, 'Salary', 'Monthly salary', 1),
    (2, 'Investments', 'Income from investments', 2);

-- Insert Expenses
INSERT INTO expenses (id, amount, date, description, user_id, category_id)
VALUES
    (1, 50.00, '2024-01-15', 'Lunch', 1, 1),
    (2, 20.00, '2024-01-16', 'Bus ticket', 2, 2);

-- Insert Incomes
INSERT INTO incomes (id, amount, date, description, user_id, category_id)
VALUES
    (1, 1500.00, '2024-01-01', 'Salary for January', 1, 1),
    (2, 500.00, '2024-01-05', 'Stock dividends', 2, 2);

-- Insert Expense Plans
INSERT INTO expense_plan (id, start_date, end_date, total_budget, spent_amount)
VALUES
    (1, '2024-01-01', '2024-01-31', 1000.00, 70.00),
    (2, '2024-02-01', '2024-02-28', 1200.00, 0.00);
