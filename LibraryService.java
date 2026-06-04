package com.lms;

import java.sql.*;

public class LibraryService {

    // View All Books
    public void viewBooks() {
        try (Connection conn = dbconnection.getconnection()) {

            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Title: " + rs.getString("tittle") +
                                ", Author: " + rs.getString("author") +
                                ", Issued: " + rs.getBoolean("isIssued"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add Book
    public void addBook(String title, String author) {
        try (Connection conn = dbconnection.getconnection()) {

            String sql =
                    "INSERT INTO books(tittle, author, isIssued) VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setBoolean(3, false);

            stmt.executeUpdate();

            System.out.println("Book Added Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Book
    public void deleteBook(int id) {
        try (Connection conn = dbconnection.getconnection()) {

            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Deleted Successfully!");
            } else {
                System.out.println("Book Not Found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Book
    public void updateBook(int id, String title, String author) {
        try (Connection conn = dbconnection.getconnection()) {

            String sql =
                    "UPDATE books SET tittle = ?, author = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setInt(3, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Updated Successfully!");
            } else {
                System.out.println("Book Not Found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Book
    public void searchBook(String keyword) {
        try (Connection conn = dbconnection.getconnection()) {

            String sql =
                    "SELECT * FROM books WHERE tittle LIKE ? OR author LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Title: " + rs.getString("tittle") +
                                ", Author: " + rs.getString("author") +
                                ", Issued: " + rs.getBoolean("isIssued"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Issue Book
    public void issueBook(int id) {
        try (Connection conn = dbconnection.getconnection()) {

            String sql =
                    "UPDATE books SET isIssued = true WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Book Issued Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Return Book
    public void returnBook(int id) {
        try (Connection conn = dbconnection.getconnection()) {

            String sql =
                    "UPDATE books SET isIssued = false WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Book Returned Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}