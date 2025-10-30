# Travene POS - Modern Build

**A Legacy Point-of-Sale System Restored for Java 17** 🚀

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9.6-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Moonrank_Public-green.svg)](config/licence.html)

## 🎯 What is This?

Travene POS (TavernerPOS) is a fork of FloreantPOS - a restaurant/bar point-of-sale system written in Java. This repo contains the **modernized and working version** built for Java 17.

### ✨ Features

- **Restaurant Management**: Orders, tables, tickets
- **Kitchen Printing**: Send orders to kitchen printers
- **Payment Processing**: Cash, card, multiple payment types
- **Inventory Tracking**: Basic inventory management
- **Reporting**: Sales reports, server tips, journals
- **Multi-User**: User roles and permissions
- **Multi-Language**: EN, DE, ES, AR, NL, GB

## 🛠️ What I Fixed

This codebase was originally written for Java 6 (circa 2015). I updated it to work on modern systems:

### Compatibility Fixes
- ✅ Updated compiler from Java 1.6 → 1.8
- ✅ Added JAXB dependencies (removed from Java 9+)
- ✅ Fixed BASE64 encoding (sun.misc → java.util.Base64)
- ✅ Disabled problematic buildnumber plugin
- ✅ Added Java 17 module access flags

### Build System
- ✅ Maven 3.9.6 configured
- ✅ All dependencies resolved
- ✅ Builds successfully with `mvn clean package`

### Database Support
- ✅ Derby Embedded (default - no server needed)
- ✅ MySQL 8.0+ support
- ✅ PostgreSQL support

## 🚀 Quick Start

### Prerequisites
- Java 17+ ([Download](https://www.oracle.com/java/technologies/downloads/))
- Maven 3.9+ (included in setup)
- Windows/Linux/Mac

### Run It Now

**Windows:**
```batch
run-travene.bat
```

**Linux/Mac:**
```bash
chmod +x tavernerpos.sh
./tavernerpos.sh
```

### Build From Source

```bash
mvn clean package -DskipTests
java -jar target/tavernerPOS.jar
```

## 📦 Project Structure

```
.
├── src/                    # Java source code
├── config/                 # Configuration files
│   ├── printers.xml       # Printer setup
│   ├── logo.png           # App logo
│   └── receipt-logo.jpg   # Receipt logo
├── i18n/                  # Language files
├── lib/                   # Runtime dependencies
├── database/              # Database files
├── pom.xml               # Maven configuration
└── README.md             # This file
```

## ⚙️ Configuration

### Database Options

**Option 1: Derby (Default)**
- No setup required
- Perfect for single terminal
- Database location: `database/derby-single/posdb`

**Option 2: MySQL**
- Edit `floreantpos.config.properties`
- Set `database_provider_name = MySQL`
- Update connection details

**Option 3: PostgreSQL**
- Edit `floreantpos.config.properties`
- Set `database_provider_name = PostgreSQL`
- Update connection details

See [DATABASE-SETUP.md](DATABASE-SETUP.md) for detailed instructions.

## 📝 Documentation

- [Setup Guide](README-SETUP.md) - Complete installation guide
- [Database Setup](DATABASE-SETUP.md) - Database configuration
- [Connection Troubleshooting](CONNECTION-PROBLEM-SOLVED.md) - Fix connection issues

## 🐛 Known Issues

- UI is dated (Java Swing from 2015)
- MySQL requires connector 8.0+ for MySQL 8.0
- Some deprecation warnings (cosmetic, doesn't affect function)

## 🤝 Contributing

This is a restored/archived version. If you want to contribute:
1. Fork the repo
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## 📜 License

**Moonrank Public License Version 1.2** (based on Mozilla Public License)

See [config/licence.html](config/licence.html) for full license text.

Original project: FloreantPOS by OROCUBE LLC

## 🙏 Credits

- **Original Project**: FloreantPOS
- **Fork**: TavernerPOS by Matt Smith
- **Modernization**: Built for Java 17 compatibility

## 🎓 What I Learned

Building this taught me about:
- Legacy Java migration
- Maven dependency resolution
- JDBC driver compatibility
- Java module system (Java 9+)
- Hibernate ORM
- Derby embedded databases

## ⚡ Quick Commands

```bash
# Build
mvn clean package

# Run
java -jar tavernerPOS.jar

# Build and run
mvn clean package && java -jar target/tavernerPOS.jar

# Run with debugging
java -Xdebug -jar tavernerPOS.jar
```

## 📊 Stats

- **Lines of Code**: ~50,000+
- **Files**: 665 Java source files
- **Build Time**: ~30 seconds
- **JAR Size**: 2.6 MB
- **Dependencies**: 70+ libraries

## 🌟 Show Your Support

If this helped you, give it a ⭐ star!

---

**Status**: ✅ Built and Working on Java 17

Last updated: October 2025
