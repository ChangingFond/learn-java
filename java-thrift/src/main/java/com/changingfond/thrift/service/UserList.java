/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.changingfond.thrift.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.EncodingUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import javax.annotation.Generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2020-9-18")
public class UserList implements org.apache.thrift.TBase<UserList, UserList._Fields>, java.io.Serializable, Cloneable, Comparable<UserList> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserList");

  private static final org.apache.thrift.protocol.TField USER_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("userList", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("page", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField LIMIT_FIELD_DESC = new org.apache.thrift.protocol.TField("limit", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserListStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserListTupleSchemeFactory());
  }

  public List<User> userList; // required
  public int page; // required
  public int limit; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_LIST((short)1, "userList"),
    PAGE((short)2, "page"),
    LIMIT((short)3, "limit");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // USER_LIST
          return USER_LIST;
        case 2: // PAGE
          return PAGE;
        case 3: // LIMIT
          return LIMIT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PAGE_ISSET_ID = 0;
  private static final int __LIMIT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_LIST, new org.apache.thrift.meta_data.FieldMetaData("userList", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, User.class))));
    tmpMap.put(_Fields.PAGE, new org.apache.thrift.meta_data.FieldMetaData("page", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LIMIT, new org.apache.thrift.meta_data.FieldMetaData("limit", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserList.class, metaDataMap);
  }

  public UserList() {
  }

  public UserList(
    List<User> userList,
    int page,
    int limit)
  {
    this();
    this.userList = userList;
    this.page = page;
    setPageIsSet(true);
    this.limit = limit;
    setLimitIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserList(UserList other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetUserList()) {
      List<User> __this__userList = new ArrayList<User>(other.userList.size());
      for (User other_element : other.userList) {
        __this__userList.add(new User(other_element));
      }
      this.userList = __this__userList;
    }
    this.page = other.page;
    this.limit = other.limit;
  }

  public UserList deepCopy() {
    return new UserList(this);
  }

  @Override
  public void clear() {
    this.userList = null;
    setPageIsSet(false);
    this.page = 0;
    setLimitIsSet(false);
    this.limit = 0;
  }

  public int getUserListSize() {
    return (this.userList == null) ? 0 : this.userList.size();
  }

  public java.util.Iterator<User> getUserListIterator() {
    return (this.userList == null) ? null : this.userList.iterator();
  }

  public void addToUserList(User elem) {
    if (this.userList == null) {
      this.userList = new ArrayList<User>();
    }
    this.userList.add(elem);
  }

  public List<User> getUserList() {
    return this.userList;
  }

  public UserList setUserList(List<User> userList) {
    this.userList = userList;
    return this;
  }

  public void unsetUserList() {
    this.userList = null;
  }

  /** Returns true if field userList is set (has been assigned a value) and false otherwise */
  public boolean isSetUserList() {
    return this.userList != null;
  }

  public void setUserListIsSet(boolean value) {
    if (!value) {
      this.userList = null;
    }
  }

  public int getPage() {
    return this.page;
  }

  public UserList setPage(int page) {
    this.page = page;
    setPageIsSet(true);
    return this;
  }

  public void unsetPage() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGE_ISSET_ID);
  }

  /** Returns true if field page is set (has been assigned a value) and false otherwise */
  public boolean isSetPage() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGE_ISSET_ID);
  }

  public void setPageIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGE_ISSET_ID, value);
  }

  public int getLimit() {
    return this.limit;
  }

  public UserList setLimit(int limit) {
    this.limit = limit;
    setLimitIsSet(true);
    return this;
  }

  public void unsetLimit() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LIMIT_ISSET_ID);
  }

  /** Returns true if field limit is set (has been assigned a value) and false otherwise */
  public boolean isSetLimit() {
    return EncodingUtils.testBit(__isset_bitfield, __LIMIT_ISSET_ID);
  }

  public void setLimitIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LIMIT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_LIST:
      if (value == null) {
        unsetUserList();
      } else {
        setUserList((List<User>)value);
      }
      break;

    case PAGE:
      if (value == null) {
        unsetPage();
      } else {
        setPage((Integer)value);
      }
      break;

    case LIMIT:
      if (value == null) {
        unsetLimit();
      } else {
        setLimit((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_LIST:
      return getUserList();

    case PAGE:
      return Integer.valueOf(getPage());

    case LIMIT:
      return Integer.valueOf(getLimit());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_LIST:
      return isSetUserList();
    case PAGE:
      return isSetPage();
    case LIMIT:
      return isSetLimit();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserList)
      return this.equals((UserList)that);
    return false;
  }

  public boolean equals(UserList that) {
    if (that == null)
      return false;

    boolean this_present_userList = true && this.isSetUserList();
    boolean that_present_userList = true && that.isSetUserList();
    if (this_present_userList || that_present_userList) {
      if (!(this_present_userList && that_present_userList))
        return false;
      if (!this.userList.equals(that.userList))
        return false;
    }

    boolean this_present_page = true;
    boolean that_present_page = true;
    if (this_present_page || that_present_page) {
      if (!(this_present_page && that_present_page))
        return false;
      if (this.page != that.page)
        return false;
    }

    boolean this_present_limit = true;
    boolean that_present_limit = true;
    if (this_present_limit || that_present_limit) {
      if (!(this_present_limit && that_present_limit))
        return false;
      if (this.limit != that.limit)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_userList = true && (isSetUserList());
    list.add(present_userList);
    if (present_userList)
      list.add(userList);

    boolean present_page = true;
    list.add(present_page);
    if (present_page)
      list.add(page);

    boolean present_limit = true;
    list.add(present_limit);
    if (present_limit)
      list.add(limit);

    return list.hashCode();
  }

  @Override
  public int compareTo(UserList other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUserList()).compareTo(other.isSetUserList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userList, other.userList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPage()).compareTo(other.isSetPage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.page, other.page);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLimit()).compareTo(other.isSetLimit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLimit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.limit, other.limit);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UserList(");
    boolean first = true;

    sb.append("userList:");
    if (this.userList == null) {
      sb.append("null");
    } else {
      sb.append(this.userList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("page:");
    sb.append(this.page);
    first = false;
    if (!first) sb.append(", ");
    sb.append("limit:");
    sb.append(this.limit);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (userList == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'userList' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'page' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'limit' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UserListStandardSchemeFactory implements SchemeFactory {
    public UserListStandardScheme getScheme() {
      return new UserListStandardScheme();
    }
  }

  private static class UserListStandardScheme extends StandardScheme<UserList> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserList struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.userList = new ArrayList<User>(_list0.size);
                User _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new User();
                  _elem1.read(iprot);
                  struct.userList.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setUserListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.page = iprot.readI32();
              struct.setPageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LIMIT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.limit = iprot.readI32();
              struct.setLimitIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetPage()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'page' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetLimit()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'limit' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserList struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.userList != null) {
        oprot.writeFieldBegin(USER_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.userList.size()));
          for (User _iter3 : struct.userList)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PAGE_FIELD_DESC);
      oprot.writeI32(struct.page);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LIMIT_FIELD_DESC);
      oprot.writeI32(struct.limit);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserListTupleSchemeFactory implements SchemeFactory {
    public UserListTupleScheme getScheme() {
      return new UserListTupleScheme();
    }
  }

  private static class UserListTupleScheme extends TupleScheme<UserList> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserList struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.userList.size());
        for (User _iter4 : struct.userList)
        {
          _iter4.write(oprot);
        }
      }
      oprot.writeI32(struct.page);
      oprot.writeI32(struct.limit);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserList struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.userList = new ArrayList<User>(_list5.size);
        User _elem6;
        for (int _i7 = 0; _i7 < _list5.size; ++_i7)
        {
          _elem6 = new User();
          _elem6.read(iprot);
          struct.userList.add(_elem6);
        }
      }
      struct.setUserListIsSet(true);
      struct.page = iprot.readI32();
      struct.setPageIsSet(true);
      struct.limit = iprot.readI32();
      struct.setLimitIsSet(true);
    }
  }

}

