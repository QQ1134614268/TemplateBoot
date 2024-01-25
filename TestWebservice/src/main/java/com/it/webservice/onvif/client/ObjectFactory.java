
package com.it.webservice.onvif.client;

import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.wsaddressing.W3CEndpointReference;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.it.sim.webservice.onvif.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TopicNamespace_QNAME = new QName("http://docs.oasis-open.org/wsn/t-1", "TopicNamespace");
    private final static QName _TopicSet_QNAME = new QName("http://docs.oasis-open.org/wsn/t-1", "TopicSet");
    private final static QName _BaseFault_QNAME = new QName("http://docs.oasis-open.org/wsrf/bf-2", "BaseFault");
    private final static QName _TopicExpression_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "TopicExpression");
    private final static QName _FixedTopicSet_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "FixedTopicSet");
    private final static QName _TopicExpressionDialect_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "TopicExpressionDialect");
    private final static QName _ConsumerReference_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "ConsumerReference");
    private final static QName _Filter_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "Filter");
    private final static QName _SubscriptionPolicy_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "SubscriptionPolicy");
    private final static QName _CreationTime_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "CreationTime");
    private final static QName _SubscriptionReference_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "SubscriptionReference");
    private final static QName _Topic_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "Topic");
    private final static QName _ProducerReference_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "ProducerReference");
    private final static QName _NotificationMessage_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "NotificationMessage");
    private final static QName _CurrentTime_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "CurrentTime");
    private final static QName _TerminationTime_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "TerminationTime");
    private final static QName _ProducerProperties_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "ProducerProperties");
    private final static QName _MessageContent_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "MessageContent");
    private final static QName _SubscribeCreationFailedFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "SubscribeCreationFailedFault");
    private final static QName _InvalidFilterFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "InvalidFilterFault");
    private final static QName _TopicExpressionDialectUnknownFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "TopicExpressionDialectUnknownFault");
    private final static QName _InvalidTopicExpressionFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "InvalidTopicExpressionFault");
    private final static QName _TopicNotSupportedFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "TopicNotSupportedFault");
    private final static QName _MultipleTopicsSpecifiedFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "MultipleTopicsSpecifiedFault");
    private final static QName _InvalidProducerPropertiesExpressionFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "InvalidProducerPropertiesExpressionFault");
    private final static QName _InvalidMessageContentExpressionFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "InvalidMessageContentExpressionFault");
    private final static QName _UnrecognizedPolicyRequestFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnrecognizedPolicyRequestFault");
    private final static QName _UnsupportedPolicyRequestFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnsupportedPolicyRequestFault");
    private final static QName _NotifyMessageNotSupportedFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "NotifyMessageNotSupportedFault");
    private final static QName _UnacceptableInitialTerminationTimeFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnacceptableInitialTerminationTimeFault");
    private final static QName _NoCurrentMessageOnTopicFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "NoCurrentMessageOnTopicFault");
    private final static QName _UnableToGetMessagesFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnableToGetMessagesFault");
    private final static QName _UnableToDestroyPullPointFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnableToDestroyPullPointFault");
    private final static QName _UnableToCreatePullPointFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnableToCreatePullPointFault");
    private final static QName _UnacceptableTerminationTimeFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnacceptableTerminationTimeFault");
    private final static QName _UnableToDestroySubscriptionFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "UnableToDestroySubscriptionFault");
    private final static QName _PauseFailedFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "PauseFailedFault");
    private final static QName _ResumeFailedFault_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "ResumeFailedFault");
    private final static QName _Include_QNAME = new QName("http://www.w3.org/2004/08/xop/include", "Include");
    private final static QName _Polygon_QNAME = new QName("http://www.onvif.org/ver10/schema", "Polygon");
    private final static QName _StringList_QNAME = new QName("http://www.onvif.org/ver10/schema", "StringList");
    private final static QName _IntRange_QNAME = new QName("http://www.onvif.org/ver10/schema", "IntRange");
    private final static QName _IntList_QNAME = new QName("http://www.onvif.org/ver10/schema", "IntList");
    private final static QName _FloatRange_QNAME = new QName("http://www.onvif.org/ver10/schema", "FloatRange");
    private final static QName _FloatList_QNAME = new QName("http://www.onvif.org/ver10/schema", "FloatList");
    private final static QName _DurationRange_QNAME = new QName("http://www.onvif.org/ver10/schema", "DurationRange");
    private final static QName _IntRectangleRange_QNAME = new QName("http://www.onvif.org/ver10/schema", "IntRectangleRange");
    private final static QName _VideoSourceConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "VideoSourceConfiguration");
    private final static QName _AudioSourceConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "AudioSourceConfiguration");
    private final static QName _VideoEncoderConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "VideoEncoderConfiguration");
    private final static QName _AudioEncoderConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "AudioEncoderConfiguration");
    private final static QName _VideoAnalyticsConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "VideoAnalyticsConfiguration");
    private final static QName _PTZConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "PTZConfiguration");
    private final static QName _MetadataConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "MetadataConfiguration");
    private final static QName _AudioOutputConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "AudioOutputConfiguration");
    private final static QName _AudioDecoderConfiguration_QNAME = new QName("http://www.onvif.org/ver10/schema", "AudioDecoderConfiguration");
    private final static QName _Polyline_QNAME = new QName("http://www.onvif.org/ver10/schema", "Polyline");
    private final static QName _PolygonOptions_QNAME = new QName("http://www.onvif.org/ver10/schema", "PolygonOptions");
    private final static QName _Envelope_QNAME = new QName("http://www.w3.org/2003/05/soap-envelope", "Envelope");
    private final static QName _Header_QNAME = new QName("http://www.w3.org/2003/05/soap-envelope", "Header");
    private final static QName _Body_QNAME = new QName("http://www.w3.org/2003/05/soap-envelope", "Body");
    private final static QName _Fault_QNAME = new QName("http://www.w3.org/2003/05/soap-envelope", "Fault");
    private final static QName _NotUnderstood_QNAME = new QName("http://www.w3.org/2003/05/soap-envelope", "NotUnderstood");
    private final static QName _Upgrade_QNAME = new QName("http://www.w3.org/2003/05/soap-envelope", "Upgrade");
    private final static QName _Capabilities_QNAME = new QName("http://www.onvif.org/ver10/device/wsdl", "Capabilities");
    private final static QName _SubscribeInitialTerminationTime_QNAME = new QName("http://docs.oasis-open.org/wsn/b-2", "InitialTerminationTime");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.it.sim.webservice.onvif.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Subscribe }
     * 
     */
    public Subscribe createSubscribe() {
        return new Subscribe();
    }

    /**
     * Create an instance of {@link GetSystemUrisResponse }
     * 
     */
    public GetSystemUrisResponse createGetSystemUrisResponse() {
        return new GetSystemUrisResponse();
    }

    /**
     * Create an instance of {@link UserCredential }
     * 
     */
    public UserCredential createUserCredential() {
        return new UserCredential();
    }

    /**
     * Create an instance of {@link StorageConfigurationData }
     * 
     */
    public StorageConfigurationData createStorageConfigurationData() {
        return new StorageConfigurationData();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link RecordingEventFilter }
     * 
     */
    public RecordingEventFilter createRecordingEventFilter() {
        return new RecordingEventFilter();
    }

    /**
     * Create an instance of {@link ConfigDescription }
     * 
     */
    public ConfigDescription createConfigDescription() {
        return new ConfigDescription();
    }

    /**
     * Create an instance of {@link ItemListDescription }
     * 
     */
    public ItemListDescription createItemListDescription() {
        return new ItemListDescription();
    }

    /**
     * Create an instance of {@link EventSubscription }
     * 
     */
    public EventSubscription createEventSubscription() {
        return new EventSubscription();
    }

    /**
     * Create an instance of {@link ColorDescriptor }
     * 
     */
    public ColorDescriptor createColorDescriptor() {
        return new ColorDescriptor();
    }

    /**
     * Create an instance of {@link ItemList }
     * 
     */
    public ItemList createItemList() {
        return new ItemList();
    }

    /**
     * Create an instance of {@link BaseFaultType }
     * 
     */
    public BaseFaultType createBaseFaultType() {
        return new BaseFaultType();
    }

    /**
     * Create an instance of {@link NotificationMessageHolderType }
     * 
     */
    public NotificationMessageHolderType createNotificationMessageHolderType() {
        return new NotificationMessageHolderType();
    }

    /**
     * Create an instance of {@link TopicNamespaceType }
     * 
     */
    public TopicNamespaceType createTopicNamespaceType() {
        return new TopicNamespaceType();
    }

    /**
     * Create an instance of {@link TopicSetType }
     * 
     */
    public TopicSetType createTopicSetType() {
        return new TopicSetType();
    }

    /**
     * Create an instance of {@link Documentation }
     * 
     */
    public Documentation createDocumentation() {
        return new Documentation();
    }

    /**
     * Create an instance of {@link QueryExpressionType }
     * 
     */
    public QueryExpressionType createQueryExpressionType() {
        return new QueryExpressionType();
    }

    /**
     * Create an instance of {@link TopicType }
     * 
     */
    public TopicType createTopicType() {
        return new TopicType();
    }

    /**
     * Create an instance of {@link TopicExpressionType }
     * 
     */
    public TopicExpressionType createTopicExpressionType() {
        return new TopicExpressionType();
    }

    /**
     * Create an instance of {@link NotificationProducerRP }
     * 
     */
    public NotificationProducerRP createNotificationProducerRP() {
        return new NotificationProducerRP();
    }

    /**
     * Create an instance of {@link FilterType }
     * 
     */
    public FilterType createFilterType() {
        return new FilterType();
    }

    /**
     * Create an instance of {@link SubscriptionPolicyType }
     * 
     */
    public SubscriptionPolicyType createSubscriptionPolicyType() {
        return new SubscriptionPolicyType();
    }

    /**
     * Create an instance of {@link SubscriptionManagerRP }
     * 
     */
    public SubscriptionManagerRP createSubscriptionManagerRP() {
        return new SubscriptionManagerRP();
    }

    /**
     * Create an instance of {@link Notify }
     * 
     */
    public Notify createNotify() {
        return new Notify();
    }

    /**
     * Create an instance of {@link QueryExpressionType2 }
     * 
     */
    public QueryExpressionType2 createQueryExpressionType2() {
        return new QueryExpressionType2();
    }

    /**
     * Create an instance of {@link UseRaw }
     * 
     */
    public UseRaw createUseRaw() {
        return new UseRaw();
    }

    /**
     * Create an instance of {@link Subscribe.SubscriptionPolicy }
     * 
     */
    public Subscribe.SubscriptionPolicy createSubscribeSubscriptionPolicy() {
        return new Subscribe.SubscriptionPolicy();
    }

    /**
     * Create an instance of {@link SubscribeResponse }
     * 
     */
    public SubscribeResponse createSubscribeResponse() {
        return new SubscribeResponse();
    }

    /**
     * Create an instance of {@link GetCurrentMessage }
     * 
     */
    public GetCurrentMessage createGetCurrentMessage() {
        return new GetCurrentMessage();
    }

    /**
     * Create an instance of {@link GetCurrentMessageResponse }
     * 
     */
    public GetCurrentMessageResponse createGetCurrentMessageResponse() {
        return new GetCurrentMessageResponse();
    }

    /**
     * Create an instance of {@link SubscribeCreationFailedFaultType }
     * 
     */
    public SubscribeCreationFailedFaultType createSubscribeCreationFailedFaultType() {
        return new SubscribeCreationFailedFaultType();
    }

    /**
     * Create an instance of {@link InvalidFilterFaultType }
     * 
     */
    public InvalidFilterFaultType createInvalidFilterFaultType() {
        return new InvalidFilterFaultType();
    }

    /**
     * Create an instance of {@link TopicExpressionDialectUnknownFaultType }
     * 
     */
    public TopicExpressionDialectUnknownFaultType createTopicExpressionDialectUnknownFaultType() {
        return new TopicExpressionDialectUnknownFaultType();
    }

    /**
     * Create an instance of {@link InvalidTopicExpressionFaultType }
     * 
     */
    public InvalidTopicExpressionFaultType createInvalidTopicExpressionFaultType() {
        return new InvalidTopicExpressionFaultType();
    }

    /**
     * Create an instance of {@link TopicNotSupportedFaultType }
     * 
     */
    public TopicNotSupportedFaultType createTopicNotSupportedFaultType() {
        return new TopicNotSupportedFaultType();
    }

    /**
     * Create an instance of {@link MultipleTopicsSpecifiedFaultType }
     * 
     */
    public MultipleTopicsSpecifiedFaultType createMultipleTopicsSpecifiedFaultType() {
        return new MultipleTopicsSpecifiedFaultType();
    }

    /**
     * Create an instance of {@link InvalidProducerPropertiesExpressionFaultType }
     * 
     */
    public InvalidProducerPropertiesExpressionFaultType createInvalidProducerPropertiesExpressionFaultType() {
        return new InvalidProducerPropertiesExpressionFaultType();
    }

    /**
     * Create an instance of {@link InvalidMessageContentExpressionFaultType }
     * 
     */
    public InvalidMessageContentExpressionFaultType createInvalidMessageContentExpressionFaultType() {
        return new InvalidMessageContentExpressionFaultType();
    }

    /**
     * Create an instance of {@link UnrecognizedPolicyRequestFaultType }
     * 
     */
    public UnrecognizedPolicyRequestFaultType createUnrecognizedPolicyRequestFaultType() {
        return new UnrecognizedPolicyRequestFaultType();
    }

    /**
     * Create an instance of {@link UnsupportedPolicyRequestFaultType }
     * 
     */
    public UnsupportedPolicyRequestFaultType createUnsupportedPolicyRequestFaultType() {
        return new UnsupportedPolicyRequestFaultType();
    }

    /**
     * Create an instance of {@link NotifyMessageNotSupportedFaultType }
     * 
     */
    public NotifyMessageNotSupportedFaultType createNotifyMessageNotSupportedFaultType() {
        return new NotifyMessageNotSupportedFaultType();
    }

    /**
     * Create an instance of {@link UnacceptableInitialTerminationTimeFaultType }
     * 
     */
    public UnacceptableInitialTerminationTimeFaultType createUnacceptableInitialTerminationTimeFaultType() {
        return new UnacceptableInitialTerminationTimeFaultType();
    }

    /**
     * Create an instance of {@link NoCurrentMessageOnTopicFaultType }
     * 
     */
    public NoCurrentMessageOnTopicFaultType createNoCurrentMessageOnTopicFaultType() {
        return new NoCurrentMessageOnTopicFaultType();
    }

    /**
     * Create an instance of {@link GetMessages }
     * 
     */
    public GetMessages createGetMessages() {
        return new GetMessages();
    }

    /**
     * Create an instance of {@link GetMessagesResponse }
     * 
     */
    public GetMessagesResponse createGetMessagesResponse() {
        return new GetMessagesResponse();
    }

    /**
     * Create an instance of {@link DestroyPullPoint }
     * 
     */
    public DestroyPullPoint createDestroyPullPoint() {
        return new DestroyPullPoint();
    }

    /**
     * Create an instance of {@link DestroyPullPointResponse }
     * 
     */
    public DestroyPullPointResponse createDestroyPullPointResponse() {
        return new DestroyPullPointResponse();
    }

    /**
     * Create an instance of {@link UnableToGetMessagesFaultType }
     * 
     */
    public UnableToGetMessagesFaultType createUnableToGetMessagesFaultType() {
        return new UnableToGetMessagesFaultType();
    }

    /**
     * Create an instance of {@link UnableToDestroyPullPointFaultType }
     * 
     */
    public UnableToDestroyPullPointFaultType createUnableToDestroyPullPointFaultType() {
        return new UnableToDestroyPullPointFaultType();
    }

    /**
     * Create an instance of {@link CreatePullPoint }
     * 
     */
    public CreatePullPoint createCreatePullPoint() {
        return new CreatePullPoint();
    }

    /**
     * Create an instance of {@link CreatePullPointResponse }
     * 
     */
    public CreatePullPointResponse createCreatePullPointResponse() {
        return new CreatePullPointResponse();
    }

    /**
     * Create an instance of {@link UnableToCreatePullPointFaultType }
     * 
     */
    public UnableToCreatePullPointFaultType createUnableToCreatePullPointFaultType() {
        return new UnableToCreatePullPointFaultType();
    }

    /**
     * Create an instance of {@link Renew }
     * 
     */
    public Renew createRenew() {
        return new Renew();
    }

    /**
     * Create an instance of {@link RenewResponse }
     * 
     */
    public RenewResponse createRenewResponse() {
        return new RenewResponse();
    }

    /**
     * Create an instance of {@link UnacceptableTerminationTimeFaultType }
     * 
     */
    public UnacceptableTerminationTimeFaultType createUnacceptableTerminationTimeFaultType() {
        return new UnacceptableTerminationTimeFaultType();
    }

    /**
     * Create an instance of {@link Unsubscribe }
     * 
     */
    public Unsubscribe createUnsubscribe() {
        return new Unsubscribe();
    }

    /**
     * Create an instance of {@link UnsubscribeResponse }
     * 
     */
    public UnsubscribeResponse createUnsubscribeResponse() {
        return new UnsubscribeResponse();
    }

    /**
     * Create an instance of {@link UnableToDestroySubscriptionFaultType }
     * 
     */
    public UnableToDestroySubscriptionFaultType createUnableToDestroySubscriptionFaultType() {
        return new UnableToDestroySubscriptionFaultType();
    }

    /**
     * Create an instance of {@link PauseSubscription }
     * 
     */
    public PauseSubscription createPauseSubscription() {
        return new PauseSubscription();
    }

    /**
     * Create an instance of {@link PauseSubscriptionResponse }
     * 
     */
    public PauseSubscriptionResponse createPauseSubscriptionResponse() {
        return new PauseSubscriptionResponse();
    }

    /**
     * Create an instance of {@link ResumeSubscription }
     * 
     */
    public ResumeSubscription createResumeSubscription() {
        return new ResumeSubscription();
    }

    /**
     * Create an instance of {@link ResumeSubscriptionResponse }
     * 
     */
    public ResumeSubscriptionResponse createResumeSubscriptionResponse() {
        return new ResumeSubscriptionResponse();
    }

    /**
     * Create an instance of {@link PauseFailedFaultType }
     * 
     */
    public PauseFailedFaultType createPauseFailedFaultType() {
        return new PauseFailedFaultType();
    }

    /**
     * Create an instance of {@link ResumeFailedFaultType }
     * 
     */
    public ResumeFailedFaultType createResumeFailedFaultType() {
        return new ResumeFailedFaultType();
    }

    /**
     * Create an instance of {@link Include }
     * 
     */
    public Include createInclude() {
        return new Include();
    }

    /**
     * Create an instance of {@link Polygon }
     * 
     */
    public Polygon createPolygon() {
        return new Polygon();
    }

    /**
     * Create an instance of {@link StringItems }
     * 
     */
    public StringItems createStringItems() {
        return new StringItems();
    }

    /**
     * Create an instance of {@link IntRange }
     * 
     */
    public IntRange createIntRange() {
        return new IntRange();
    }

    /**
     * Create an instance of {@link FloatRange }
     * 
     */
    public FloatRange createFloatRange() {
        return new FloatRange();
    }

    /**
     * Create an instance of {@link DurationRange }
     * 
     */
    public DurationRange createDurationRange() {
        return new DurationRange();
    }

    /**
     * Create an instance of {@link IntRectangleRange }
     * 
     */
    public IntRectangleRange createIntRectangleRange() {
        return new IntRectangleRange();
    }

    /**
     * Create an instance of {@link VideoSourceConfiguration }
     * 
     */
    public VideoSourceConfiguration createVideoSourceConfiguration() {
        return new VideoSourceConfiguration();
    }

    /**
     * Create an instance of {@link AudioSourceConfiguration }
     * 
     */
    public AudioSourceConfiguration createAudioSourceConfiguration() {
        return new AudioSourceConfiguration();
    }

    /**
     * Create an instance of {@link VideoEncoderConfiguration }
     * 
     */
    public VideoEncoderConfiguration createVideoEncoderConfiguration() {
        return new VideoEncoderConfiguration();
    }

    /**
     * Create an instance of {@link AudioEncoderConfiguration }
     * 
     */
    public AudioEncoderConfiguration createAudioEncoderConfiguration() {
        return new AudioEncoderConfiguration();
    }

    /**
     * Create an instance of {@link VideoAnalyticsConfiguration }
     * 
     */
    public VideoAnalyticsConfiguration createVideoAnalyticsConfiguration() {
        return new VideoAnalyticsConfiguration();
    }

    /**
     * Create an instance of {@link PTZConfiguration }
     * 
     */
    public PTZConfiguration createPTZConfiguration() {
        return new PTZConfiguration();
    }

    /**
     * Create an instance of {@link MetadataConfiguration }
     * 
     */
    public MetadataConfiguration createMetadataConfiguration() {
        return new MetadataConfiguration();
    }

    /**
     * Create an instance of {@link AudioOutputConfiguration }
     * 
     */
    public AudioOutputConfiguration createAudioOutputConfiguration() {
        return new AudioOutputConfiguration();
    }

    /**
     * Create an instance of {@link AudioDecoderConfiguration }
     * 
     */
    public AudioDecoderConfiguration createAudioDecoderConfiguration() {
        return new AudioDecoderConfiguration();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link MessageExtension }
     * 
     */
    public MessageExtension createMessageExtension() {
        return new MessageExtension();
    }

    /**
     * Create an instance of {@link Polyline }
     * 
     */
    public Polyline createPolyline() {
        return new Polyline();
    }

    /**
     * Create an instance of {@link PolygonOptions }
     * 
     */
    public PolygonOptions createPolygonOptions() {
        return new PolygonOptions();
    }

    /**
     * Create an instance of {@link Vector2D }
     * 
     */
    public Vector2D createVector2D() {
        return new Vector2D();
    }

    /**
     * Create an instance of {@link Vector1D }
     * 
     */
    public Vector1D createVector1D() {
        return new Vector1D();
    }

    /**
     * Create an instance of {@link PTZVector }
     * 
     */
    public PTZVector createPTZVector() {
        return new PTZVector();
    }

    /**
     * Create an instance of {@link PTZStatus }
     * 
     */
    public PTZStatus createPTZStatus() {
        return new PTZStatus();
    }

    /**
     * Create an instance of {@link PTZMoveStatus }
     * 
     */
    public PTZMoveStatus createPTZMoveStatus() {
        return new PTZMoveStatus();
    }

    /**
     * Create an instance of {@link Vector }
     * 
     */
    public Vector createVector() {
        return new Vector();
    }

    /**
     * Create an instance of {@link Rectangle }
     * 
     */
    public Rectangle createRectangle() {
        return new Rectangle();
    }

    /**
     * Create an instance of {@link Color }
     * 
     */
    public Color createColor() {
        return new Color();
    }

    /**
     * Create an instance of {@link ColorCovariance }
     * 
     */
    public ColorCovariance createColorCovariance() {
        return new ColorCovariance();
    }

    /**
     * Create an instance of {@link Transformation }
     * 
     */
    public Transformation createTransformation() {
        return new Transformation();
    }

    /**
     * Create an instance of {@link TransformationExtension }
     * 
     */
    public TransformationExtension createTransformationExtension() {
        return new TransformationExtension();
    }

    /**
     * Create an instance of {@link GeoLocation }
     * 
     */
    public GeoLocation createGeoLocation() {
        return new GeoLocation();
    }

    /**
     * Create an instance of {@link GeoOrientation }
     * 
     */
    public GeoOrientation createGeoOrientation() {
        return new GeoOrientation();
    }

    /**
     * Create an instance of {@link LocalLocation }
     * 
     */
    public LocalLocation createLocalLocation() {
        return new LocalLocation();
    }

    /**
     * Create an instance of {@link LocalOrientation }
     * 
     */
    public LocalOrientation createLocalOrientation() {
        return new LocalOrientation();
    }

    /**
     * Create an instance of {@link LocationEntity }
     * 
     */
    public LocationEntity createLocationEntity() {
        return new LocationEntity();
    }

    /**
     * Create an instance of {@link DeviceEntity }
     * 
     */
    public DeviceEntity createDeviceEntity() {
        return new DeviceEntity();
    }

    /**
     * Create an instance of {@link IntRectangle }
     * 
     */
    public IntRectangle createIntRectangle() {
        return new IntRectangle();
    }

    /**
     * Create an instance of {@link IntItems }
     * 
     */
    public IntItems createIntItems() {
        return new IntItems();
    }

    /**
     * Create an instance of {@link FloatItems }
     * 
     */
    public FloatItems createFloatItems() {
        return new FloatItems();
    }

    /**
     * Create an instance of {@link AnyHolder }
     * 
     */
    public AnyHolder createAnyHolder() {
        return new AnyHolder();
    }

    /**
     * Create an instance of {@link VideoSource }
     * 
     */
    public VideoSource createVideoSource() {
        return new VideoSource();
    }

    /**
     * Create an instance of {@link VideoSourceExtension }
     * 
     */
    public VideoSourceExtension createVideoSourceExtension() {
        return new VideoSourceExtension();
    }

    /**
     * Create an instance of {@link VideoSourceExtension2 }
     * 
     */
    public VideoSourceExtension2 createVideoSourceExtension2() {
        return new VideoSourceExtension2();
    }

    /**
     * Create an instance of {@link AudioSource }
     * 
     */
    public AudioSource createAudioSource() {
        return new AudioSource();
    }

    /**
     * Create an instance of {@link Profile }
     * 
     */
    public Profile createProfile() {
        return new Profile();
    }

    /**
     * Create an instance of {@link ProfileExtension }
     * 
     */
    public ProfileExtension createProfileExtension() {
        return new ProfileExtension();
    }

    /**
     * Create an instance of {@link ProfileExtension2 }
     * 
     */
    public ProfileExtension2 createProfileExtension2() {
        return new ProfileExtension2();
    }

    /**
     * Create an instance of {@link ConfigurationEntity }
     * 
     */
    public ConfigurationEntity createConfigurationEntity() {
        return new ConfigurationEntity();
    }

    /**
     * Create an instance of {@link VideoSourceConfigurationExtension }
     * 
     */
    public VideoSourceConfigurationExtension createVideoSourceConfigurationExtension() {
        return new VideoSourceConfigurationExtension();
    }

    /**
     * Create an instance of {@link VideoSourceConfigurationExtension2 }
     * 
     */
    public VideoSourceConfigurationExtension2 createVideoSourceConfigurationExtension2() {
        return new VideoSourceConfigurationExtension2();
    }

    /**
     * Create an instance of {@link Rotate }
     * 
     */
    public Rotate createRotate() {
        return new Rotate();
    }

    /**
     * Create an instance of {@link RotateExtension }
     * 
     */
    public RotateExtension createRotateExtension() {
        return new RotateExtension();
    }

    /**
     * Create an instance of {@link LensProjection }
     * 
     */
    public LensProjection createLensProjection() {
        return new LensProjection();
    }

    /**
     * Create an instance of {@link LensOffset }
     * 
     */
    public LensOffset createLensOffset() {
        return new LensOffset();
    }

    /**
     * Create an instance of {@link LensDescription }
     * 
     */
    public LensDescription createLensDescription() {
        return new LensDescription();
    }

    /**
     * Create an instance of {@link VideoSourceConfigurationOptions }
     * 
     */
    public VideoSourceConfigurationOptions createVideoSourceConfigurationOptions() {
        return new VideoSourceConfigurationOptions();
    }

    /**
     * Create an instance of {@link VideoSourceConfigurationOptionsExtension }
     * 
     */
    public VideoSourceConfigurationOptionsExtension createVideoSourceConfigurationOptionsExtension() {
        return new VideoSourceConfigurationOptionsExtension();
    }

    /**
     * Create an instance of {@link VideoSourceConfigurationOptionsExtension2 }
     * 
     */
    public VideoSourceConfigurationOptionsExtension2 createVideoSourceConfigurationOptionsExtension2() {
        return new VideoSourceConfigurationOptionsExtension2();
    }

    /**
     * Create an instance of {@link RotateOptions }
     * 
     */
    public RotateOptions createRotateOptions() {
        return new RotateOptions();
    }

    /**
     * Create an instance of {@link RotateOptionsExtension }
     * 
     */
    public RotateOptionsExtension createRotateOptionsExtension() {
        return new RotateOptionsExtension();
    }

    /**
     * Create an instance of {@link SceneOrientation }
     * 
     */
    public SceneOrientation createSceneOrientation() {
        return new SceneOrientation();
    }

    /**
     * Create an instance of {@link VideoResolution }
     * 
     */
    public VideoResolution createVideoResolution() {
        return new VideoResolution();
    }

    /**
     * Create an instance of {@link VideoRateControl }
     * 
     */
    public VideoRateControl createVideoRateControl() {
        return new VideoRateControl();
    }

    /**
     * Create an instance of {@link Mpeg4Configuration }
     * 
     */
    public Mpeg4Configuration createMpeg4Configuration() {
        return new Mpeg4Configuration();
    }

    /**
     * Create an instance of {@link H264Configuration }
     * 
     */
    public H264Configuration createH264Configuration() {
        return new H264Configuration();
    }

    /**
     * Create an instance of {@link VideoEncoderConfigurationOptions }
     * 
     */
    public VideoEncoderConfigurationOptions createVideoEncoderConfigurationOptions() {
        return new VideoEncoderConfigurationOptions();
    }

    /**
     * Create an instance of {@link VideoEncoderOptionsExtension }
     * 
     */
    public VideoEncoderOptionsExtension createVideoEncoderOptionsExtension() {
        return new VideoEncoderOptionsExtension();
    }

    /**
     * Create an instance of {@link VideoEncoderOptionsExtension2 }
     * 
     */
    public VideoEncoderOptionsExtension2 createVideoEncoderOptionsExtension2() {
        return new VideoEncoderOptionsExtension2();
    }

    /**
     * Create an instance of {@link JpegOptions }
     * 
     */
    public JpegOptions createJpegOptions() {
        return new JpegOptions();
    }

    /**
     * Create an instance of {@link JpegOptions2 }
     * 
     */
    public JpegOptions2 createJpegOptions2() {
        return new JpegOptions2();
    }

    /**
     * Create an instance of {@link Mpeg4Options }
     * 
     */
    public Mpeg4Options createMpeg4Options() {
        return new Mpeg4Options();
    }

    /**
     * Create an instance of {@link Mpeg4Options2 }
     * 
     */
    public Mpeg4Options2 createMpeg4Options2() {
        return new Mpeg4Options2();
    }

    /**
     * Create an instance of {@link H264Options }
     * 
     */
    public H264Options createH264Options() {
        return new H264Options();
    }

    /**
     * Create an instance of {@link H264Options2 }
     * 
     */
    public H264Options2 createH264Options2() {
        return new H264Options2();
    }

    /**
     * Create an instance of {@link VideoEncoder2Configuration }
     * 
     */
    public VideoEncoder2Configuration createVideoEncoder2Configuration() {
        return new VideoEncoder2Configuration();
    }

    /**
     * Create an instance of {@link VideoResolution2 }
     * 
     */
    public VideoResolution2 createVideoResolution2() {
        return new VideoResolution2();
    }

    /**
     * Create an instance of {@link VideoRateControl2 }
     * 
     */
    public VideoRateControl2 createVideoRateControl2() {
        return new VideoRateControl2();
    }

    /**
     * Create an instance of {@link VideoEncoder2ConfigurationOptions }
     * 
     */
    public VideoEncoder2ConfigurationOptions createVideoEncoder2ConfigurationOptions() {
        return new VideoEncoder2ConfigurationOptions();
    }

    /**
     * Create an instance of {@link AudioSourceConfigurationOptions }
     * 
     */
    public AudioSourceConfigurationOptions createAudioSourceConfigurationOptions() {
        return new AudioSourceConfigurationOptions();
    }

    /**
     * Create an instance of {@link AudioSourceOptionsExtension }
     * 
     */
    public AudioSourceOptionsExtension createAudioSourceOptionsExtension() {
        return new AudioSourceOptionsExtension();
    }

    /**
     * Create an instance of {@link AudioEncoderConfigurationOptions }
     * 
     */
    public AudioEncoderConfigurationOptions createAudioEncoderConfigurationOptions() {
        return new AudioEncoderConfigurationOptions();
    }

    /**
     * Create an instance of {@link AudioEncoderConfigurationOption }
     * 
     */
    public AudioEncoderConfigurationOption createAudioEncoderConfigurationOption() {
        return new AudioEncoderConfigurationOption();
    }

    /**
     * Create an instance of {@link AudioEncoder2Configuration }
     * 
     */
    public AudioEncoder2Configuration createAudioEncoder2Configuration() {
        return new AudioEncoder2Configuration();
    }

    /**
     * Create an instance of {@link AudioEncoder2ConfigurationOptions }
     * 
     */
    public AudioEncoder2ConfigurationOptions createAudioEncoder2ConfigurationOptions() {
        return new AudioEncoder2ConfigurationOptions();
    }

    /**
     * Create an instance of {@link MetadataConfigurationExtension }
     * 
     */
    public MetadataConfigurationExtension createMetadataConfigurationExtension() {
        return new MetadataConfigurationExtension();
    }

    /**
     * Create an instance of {@link PTZFilter }
     * 
     */
    public PTZFilter createPTZFilter() {
        return new PTZFilter();
    }

    /**
     * Create an instance of {@link MetadataConfigurationOptions }
     * 
     */
    public MetadataConfigurationOptions createMetadataConfigurationOptions() {
        return new MetadataConfigurationOptions();
    }

    /**
     * Create an instance of {@link MetadataConfigurationOptionsExtension }
     * 
     */
    public MetadataConfigurationOptionsExtension createMetadataConfigurationOptionsExtension() {
        return new MetadataConfigurationOptionsExtension();
    }

    /**
     * Create an instance of {@link MetadataConfigurationOptionsExtension2 }
     * 
     */
    public MetadataConfigurationOptionsExtension2 createMetadataConfigurationOptionsExtension2() {
        return new MetadataConfigurationOptionsExtension2();
    }

    /**
     * Create an instance of {@link PTZStatusFilterOptions }
     * 
     */
    public PTZStatusFilterOptions createPTZStatusFilterOptions() {
        return new PTZStatusFilterOptions();
    }

    /**
     * Create an instance of {@link PTZStatusFilterOptionsExtension }
     * 
     */
    public PTZStatusFilterOptionsExtension createPTZStatusFilterOptionsExtension() {
        return new PTZStatusFilterOptionsExtension();
    }

    /**
     * Create an instance of {@link VideoOutput }
     * 
     */
    public VideoOutput createVideoOutput() {
        return new VideoOutput();
    }

    /**
     * Create an instance of {@link VideoOutputExtension }
     * 
     */
    public VideoOutputExtension createVideoOutputExtension() {
        return new VideoOutputExtension();
    }

    /**
     * Create an instance of {@link VideoOutputConfiguration }
     * 
     */
    public VideoOutputConfiguration createVideoOutputConfiguration() {
        return new VideoOutputConfiguration();
    }

    /**
     * Create an instance of {@link VideoOutputConfigurationOptions }
     * 
     */
    public VideoOutputConfigurationOptions createVideoOutputConfigurationOptions() {
        return new VideoOutputConfigurationOptions();
    }

    /**
     * Create an instance of {@link VideoDecoderConfigurationOptions }
     * 
     */
    public VideoDecoderConfigurationOptions createVideoDecoderConfigurationOptions() {
        return new VideoDecoderConfigurationOptions();
    }

    /**
     * Create an instance of {@link H264DecOptions }
     * 
     */
    public H264DecOptions createH264DecOptions() {
        return new H264DecOptions();
    }

    /**
     * Create an instance of {@link JpegDecOptions }
     * 
     */
    public JpegDecOptions createJpegDecOptions() {
        return new JpegDecOptions();
    }

    /**
     * Create an instance of {@link Mpeg4DecOptions }
     * 
     */
    public Mpeg4DecOptions createMpeg4DecOptions() {
        return new Mpeg4DecOptions();
    }

    /**
     * Create an instance of {@link VideoDecoderConfigurationOptionsExtension }
     * 
     */
    public VideoDecoderConfigurationOptionsExtension createVideoDecoderConfigurationOptionsExtension() {
        return new VideoDecoderConfigurationOptionsExtension();
    }

    /**
     * Create an instance of {@link AudioOutput }
     * 
     */
    public AudioOutput createAudioOutput() {
        return new AudioOutput();
    }

    /**
     * Create an instance of {@link AudioOutputConfigurationOptions }
     * 
     */
    public AudioOutputConfigurationOptions createAudioOutputConfigurationOptions() {
        return new AudioOutputConfigurationOptions();
    }

    /**
     * Create an instance of {@link AudioDecoderConfigurationOptions }
     * 
     */
    public AudioDecoderConfigurationOptions createAudioDecoderConfigurationOptions() {
        return new AudioDecoderConfigurationOptions();
    }

    /**
     * Create an instance of {@link G711DecOptions }
     * 
     */
    public G711DecOptions createG711DecOptions() {
        return new G711DecOptions();
    }

    /**
     * Create an instance of {@link AACDecOptions }
     * 
     */
    public AACDecOptions createAACDecOptions() {
        return new AACDecOptions();
    }

    /**
     * Create an instance of {@link G726DecOptions }
     * 
     */
    public G726DecOptions createG726DecOptions() {
        return new G726DecOptions();
    }

    /**
     * Create an instance of {@link AudioDecoderConfigurationOptionsExtension }
     * 
     */
    public AudioDecoderConfigurationOptionsExtension createAudioDecoderConfigurationOptionsExtension() {
        return new AudioDecoderConfigurationOptionsExtension();
    }

    /**
     * Create an instance of {@link MulticastConfiguration }
     * 
     */
    public MulticastConfiguration createMulticastConfiguration() {
        return new MulticastConfiguration();
    }

    /**
     * Create an instance of {@link StreamSetup }
     * 
     */
    public StreamSetup createStreamSetup() {
        return new StreamSetup();
    }

    /**
     * Create an instance of {@link Transport }
     * 
     */
    public Transport createTransport() {
        return new Transport();
    }

    /**
     * Create an instance of {@link MediaUri }
     * 
     */
    public MediaUri createMediaUri() {
        return new MediaUri();
    }

    /**
     * Create an instance of {@link Scope }
     * 
     */
    public Scope createScope() {
        return new Scope();
    }

    /**
     * Create an instance of {@link NetworkInterface }
     * 
     */
    public NetworkInterface createNetworkInterface() {
        return new NetworkInterface();
    }

    /**
     * Create an instance of {@link NetworkInterfaceExtension }
     * 
     */
    public NetworkInterfaceExtension createNetworkInterfaceExtension() {
        return new NetworkInterfaceExtension();
    }

    /**
     * Create an instance of {@link Dot3Configuration }
     * 
     */
    public Dot3Configuration createDot3Configuration() {
        return new Dot3Configuration();
    }

    /**
     * Create an instance of {@link NetworkInterfaceExtension2 }
     * 
     */
    public NetworkInterfaceExtension2 createNetworkInterfaceExtension2() {
        return new NetworkInterfaceExtension2();
    }

    /**
     * Create an instance of {@link NetworkInterfaceLink }
     * 
     */
    public NetworkInterfaceLink createNetworkInterfaceLink() {
        return new NetworkInterfaceLink();
    }

    /**
     * Create an instance of {@link NetworkInterfaceConnectionSetting }
     * 
     */
    public NetworkInterfaceConnectionSetting createNetworkInterfaceConnectionSetting() {
        return new NetworkInterfaceConnectionSetting();
    }

    /**
     * Create an instance of {@link NetworkInterfaceInfo }
     * 
     */
    public NetworkInterfaceInfo createNetworkInterfaceInfo() {
        return new NetworkInterfaceInfo();
    }

    /**
     * Create an instance of {@link IPv6NetworkInterface }
     * 
     */
    public IPv6NetworkInterface createIPv6NetworkInterface() {
        return new IPv6NetworkInterface();
    }

    /**
     * Create an instance of {@link IPv4NetworkInterface }
     * 
     */
    public IPv4NetworkInterface createIPv4NetworkInterface() {
        return new IPv4NetworkInterface();
    }

    /**
     * Create an instance of {@link IPv4Configuration }
     * 
     */
    public IPv4Configuration createIPv4Configuration() {
        return new IPv4Configuration();
    }

    /**
     * Create an instance of {@link IPv6Configuration }
     * 
     */
    public IPv6Configuration createIPv6Configuration() {
        return new IPv6Configuration();
    }

    /**
     * Create an instance of {@link IPv6ConfigurationExtension }
     * 
     */
    public IPv6ConfigurationExtension createIPv6ConfigurationExtension() {
        return new IPv6ConfigurationExtension();
    }

    /**
     * Create an instance of {@link NetworkProtocol }
     * 
     */
    public NetworkProtocol createNetworkProtocol() {
        return new NetworkProtocol();
    }

    /**
     * Create an instance of {@link NetworkProtocolExtension }
     * 
     */
    public NetworkProtocolExtension createNetworkProtocolExtension() {
        return new NetworkProtocolExtension();
    }

    /**
     * Create an instance of {@link NetworkHost }
     * 
     */
    public NetworkHost createNetworkHost() {
        return new NetworkHost();
    }

    /**
     * Create an instance of {@link NetworkHostExtension }
     * 
     */
    public NetworkHostExtension createNetworkHostExtension() {
        return new NetworkHostExtension();
    }

    /**
     * Create an instance of {@link IPAddress }
     * 
     */
    public IPAddress createIPAddress() {
        return new IPAddress();
    }

    /**
     * Create an instance of {@link PrefixedIPv4Address }
     * 
     */
    public PrefixedIPv4Address createPrefixedIPv4Address() {
        return new PrefixedIPv4Address();
    }

    /**
     * Create an instance of {@link PrefixedIPv6Address }
     * 
     */
    public PrefixedIPv6Address createPrefixedIPv6Address() {
        return new PrefixedIPv6Address();
    }

    /**
     * Create an instance of {@link HostnameInformation }
     * 
     */
    public HostnameInformation createHostnameInformation() {
        return new HostnameInformation();
    }

    /**
     * Create an instance of {@link HostnameInformationExtension }
     * 
     */
    public HostnameInformationExtension createHostnameInformationExtension() {
        return new HostnameInformationExtension();
    }

    /**
     * Create an instance of {@link DNSInformation }
     * 
     */
    public DNSInformation createDNSInformation() {
        return new DNSInformation();
    }

    /**
     * Create an instance of {@link DNSInformationExtension }
     * 
     */
    public DNSInformationExtension createDNSInformationExtension() {
        return new DNSInformationExtension();
    }

    /**
     * Create an instance of {@link NTPInformation }
     * 
     */
    public NTPInformation createNTPInformation() {
        return new NTPInformation();
    }

    /**
     * Create an instance of {@link NTPInformationExtension }
     * 
     */
    public NTPInformationExtension createNTPInformationExtension() {
        return new NTPInformationExtension();
    }

    /**
     * Create an instance of {@link DynamicDNSInformation }
     * 
     */
    public DynamicDNSInformation createDynamicDNSInformation() {
        return new DynamicDNSInformation();
    }

    /**
     * Create an instance of {@link DynamicDNSInformationExtension }
     * 
     */
    public DynamicDNSInformationExtension createDynamicDNSInformationExtension() {
        return new DynamicDNSInformationExtension();
    }

    /**
     * Create an instance of {@link NetworkInterfaceSetConfiguration }
     * 
     */
    public NetworkInterfaceSetConfiguration createNetworkInterfaceSetConfiguration() {
        return new NetworkInterfaceSetConfiguration();
    }

    /**
     * Create an instance of {@link NetworkInterfaceSetConfigurationExtension }
     * 
     */
    public NetworkInterfaceSetConfigurationExtension createNetworkInterfaceSetConfigurationExtension() {
        return new NetworkInterfaceSetConfigurationExtension();
    }

    /**
     * Create an instance of {@link IPv6NetworkInterfaceSetConfiguration }
     * 
     */
    public IPv6NetworkInterfaceSetConfiguration createIPv6NetworkInterfaceSetConfiguration() {
        return new IPv6NetworkInterfaceSetConfiguration();
    }

    /**
     * Create an instance of {@link IPv4NetworkInterfaceSetConfiguration }
     * 
     */
    public IPv4NetworkInterfaceSetConfiguration createIPv4NetworkInterfaceSetConfiguration() {
        return new IPv4NetworkInterfaceSetConfiguration();
    }

    /**
     * Create an instance of {@link NetworkGateway }
     * 
     */
    public NetworkGateway createNetworkGateway() {
        return new NetworkGateway();
    }

    /**
     * Create an instance of {@link NetworkZeroConfiguration }
     * 
     */
    public NetworkZeroConfiguration createNetworkZeroConfiguration() {
        return new NetworkZeroConfiguration();
    }

    /**
     * Create an instance of {@link NetworkZeroConfigurationExtension }
     * 
     */
    public NetworkZeroConfigurationExtension createNetworkZeroConfigurationExtension() {
        return new NetworkZeroConfigurationExtension();
    }

    /**
     * Create an instance of {@link NetworkZeroConfigurationExtension2 }
     * 
     */
    public NetworkZeroConfigurationExtension2 createNetworkZeroConfigurationExtension2() {
        return new NetworkZeroConfigurationExtension2();
    }

    /**
     * Create an instance of {@link IPAddressFilter }
     * 
     */
    public IPAddressFilter createIPAddressFilter() {
        return new IPAddressFilter();
    }

    /**
     * Create an instance of {@link IPAddressFilterExtension }
     * 
     */
    public IPAddressFilterExtension createIPAddressFilterExtension() {
        return new IPAddressFilterExtension();
    }

    /**
     * Create an instance of {@link Dot11Configuration }
     * 
     */
    public Dot11Configuration createDot11Configuration() {
        return new Dot11Configuration();
    }

    /**
     * Create an instance of {@link Dot11SecurityConfiguration }
     * 
     */
    public Dot11SecurityConfiguration createDot11SecurityConfiguration() {
        return new Dot11SecurityConfiguration();
    }

    /**
     * Create an instance of {@link Dot11SecurityConfigurationExtension }
     * 
     */
    public Dot11SecurityConfigurationExtension createDot11SecurityConfigurationExtension() {
        return new Dot11SecurityConfigurationExtension();
    }

    /**
     * Create an instance of {@link Dot11PSKSet }
     * 
     */
    public Dot11PSKSet createDot11PSKSet() {
        return new Dot11PSKSet();
    }

    /**
     * Create an instance of {@link Dot11PSKSetExtension }
     * 
     */
    public Dot11PSKSetExtension createDot11PSKSetExtension() {
        return new Dot11PSKSetExtension();
    }

    /**
     * Create an instance of {@link NetworkInterfaceSetConfigurationExtension2 }
     * 
     */
    public NetworkInterfaceSetConfigurationExtension2 createNetworkInterfaceSetConfigurationExtension2() {
        return new NetworkInterfaceSetConfigurationExtension2();
    }

    /**
     * Create an instance of {@link Dot11Capabilities }
     * 
     */
    public Dot11Capabilities createDot11Capabilities() {
        return new Dot11Capabilities();
    }

    /**
     * Create an instance of {@link Dot11Status }
     * 
     */
    public Dot11Status createDot11Status() {
        return new Dot11Status();
    }

    /**
     * Create an instance of {@link Dot11AvailableNetworks }
     * 
     */
    public Dot11AvailableNetworks createDot11AvailableNetworks() {
        return new Dot11AvailableNetworks();
    }

    /**
     * Create an instance of {@link Dot11AvailableNetworksExtension }
     * 
     */
    public Dot11AvailableNetworksExtension createDot11AvailableNetworksExtension() {
        return new Dot11AvailableNetworksExtension();
    }

    /**
     * Create an instance of {@link Capabilities }
     * 
     */
    public Capabilities createCapabilities() {
        return new Capabilities();
    }

    /**
     * Create an instance of {@link CapabilitiesExtension }
     * 
     */
    public CapabilitiesExtension createCapabilitiesExtension() {
        return new CapabilitiesExtension();
    }

    /**
     * Create an instance of {@link CapabilitiesExtension2 }
     * 
     */
    public CapabilitiesExtension2 createCapabilitiesExtension2() {
        return new CapabilitiesExtension2();
    }

    /**
     * Create an instance of {@link AnalyticsCapabilities }
     * 
     */
    public AnalyticsCapabilities createAnalyticsCapabilities() {
        return new AnalyticsCapabilities();
    }

    /**
     * Create an instance of {@link DeviceCapabilities }
     * 
     */
    public DeviceCapabilities createDeviceCapabilities() {
        return new DeviceCapabilities();
    }

    /**
     * Create an instance of {@link DeviceCapabilitiesExtension }
     * 
     */
    public DeviceCapabilitiesExtension createDeviceCapabilitiesExtension() {
        return new DeviceCapabilitiesExtension();
    }

    /**
     * Create an instance of {@link EventCapabilities }
     * 
     */
    public EventCapabilities createEventCapabilities() {
        return new EventCapabilities();
    }

    /**
     * Create an instance of {@link IOCapabilities }
     * 
     */
    public IOCapabilities createIOCapabilities() {
        return new IOCapabilities();
    }

    /**
     * Create an instance of {@link IOCapabilitiesExtension }
     * 
     */
    public IOCapabilitiesExtension createIOCapabilitiesExtension() {
        return new IOCapabilitiesExtension();
    }

    /**
     * Create an instance of {@link IOCapabilitiesExtension2 }
     * 
     */
    public IOCapabilitiesExtension2 createIOCapabilitiesExtension2() {
        return new IOCapabilitiesExtension2();
    }

    /**
     * Create an instance of {@link MediaCapabilities }
     * 
     */
    public MediaCapabilities createMediaCapabilities() {
        return new MediaCapabilities();
    }

    /**
     * Create an instance of {@link MediaCapabilitiesExtension }
     * 
     */
    public MediaCapabilitiesExtension createMediaCapabilitiesExtension() {
        return new MediaCapabilitiesExtension();
    }

    /**
     * Create an instance of {@link RealTimeStreamingCapabilities }
     * 
     */
    public RealTimeStreamingCapabilities createRealTimeStreamingCapabilities() {
        return new RealTimeStreamingCapabilities();
    }

    /**
     * Create an instance of {@link RealTimeStreamingCapabilitiesExtension }
     * 
     */
    public RealTimeStreamingCapabilitiesExtension createRealTimeStreamingCapabilitiesExtension() {
        return new RealTimeStreamingCapabilitiesExtension();
    }

    /**
     * Create an instance of {@link ProfileCapabilities }
     * 
     */
    public ProfileCapabilities createProfileCapabilities() {
        return new ProfileCapabilities();
    }

    /**
     * Create an instance of {@link NetworkCapabilities }
     * 
     */
    public NetworkCapabilities createNetworkCapabilities() {
        return new NetworkCapabilities();
    }

    /**
     * Create an instance of {@link NetworkCapabilitiesExtension }
     * 
     */
    public NetworkCapabilitiesExtension createNetworkCapabilitiesExtension() {
        return new NetworkCapabilitiesExtension();
    }

    /**
     * Create an instance of {@link NetworkCapabilitiesExtension2 }
     * 
     */
    public NetworkCapabilitiesExtension2 createNetworkCapabilitiesExtension2() {
        return new NetworkCapabilitiesExtension2();
    }

    /**
     * Create an instance of {@link SecurityCapabilities }
     * 
     */
    public SecurityCapabilities createSecurityCapabilities() {
        return new SecurityCapabilities();
    }

    /**
     * Create an instance of {@link SecurityCapabilitiesExtension }
     * 
     */
    public SecurityCapabilitiesExtension createSecurityCapabilitiesExtension() {
        return new SecurityCapabilitiesExtension();
    }

    /**
     * Create an instance of {@link SecurityCapabilitiesExtension2 }
     * 
     */
    public SecurityCapabilitiesExtension2 createSecurityCapabilitiesExtension2() {
        return new SecurityCapabilitiesExtension2();
    }

    /**
     * Create an instance of {@link SystemCapabilities }
     * 
     */
    public SystemCapabilities createSystemCapabilities() {
        return new SystemCapabilities();
    }

    /**
     * Create an instance of {@link SystemCapabilitiesExtension }
     * 
     */
    public SystemCapabilitiesExtension createSystemCapabilitiesExtension() {
        return new SystemCapabilitiesExtension();
    }

    /**
     * Create an instance of {@link SystemCapabilitiesExtension2 }
     * 
     */
    public SystemCapabilitiesExtension2 createSystemCapabilitiesExtension2() {
        return new SystemCapabilitiesExtension2();
    }

    /**
     * Create an instance of {@link OnvifVersion }
     * 
     */
    public OnvifVersion createOnvifVersion() {
        return new OnvifVersion();
    }

    /**
     * Create an instance of {@link ImagingCapabilities }
     * 
     */
    public ImagingCapabilities createImagingCapabilities() {
        return new ImagingCapabilities();
    }

    /**
     * Create an instance of {@link PTZCapabilities }
     * 
     */
    public PTZCapabilities createPTZCapabilities() {
        return new PTZCapabilities();
    }

    /**
     * Create an instance of {@link DeviceIOCapabilities }
     * 
     */
    public DeviceIOCapabilities createDeviceIOCapabilities() {
        return new DeviceIOCapabilities();
    }

    /**
     * Create an instance of {@link DisplayCapabilities }
     * 
     */
    public DisplayCapabilities createDisplayCapabilities() {
        return new DisplayCapabilities();
    }

    /**
     * Create an instance of {@link RecordingCapabilities }
     * 
     */
    public RecordingCapabilities createRecordingCapabilities() {
        return new RecordingCapabilities();
    }

    /**
     * Create an instance of {@link SearchCapabilities }
     * 
     */
    public SearchCapabilities createSearchCapabilities() {
        return new SearchCapabilities();
    }

    /**
     * Create an instance of {@link ReplayCapabilities }
     * 
     */
    public ReplayCapabilities createReplayCapabilities() {
        return new ReplayCapabilities();
    }

    /**
     * Create an instance of {@link ReceiverCapabilities }
     * 
     */
    public ReceiverCapabilities createReceiverCapabilities() {
        return new ReceiverCapabilities();
    }

    /**
     * Create an instance of {@link AnalyticsDeviceCapabilities }
     * 
     */
    public AnalyticsDeviceCapabilities createAnalyticsDeviceCapabilities() {
        return new AnalyticsDeviceCapabilities();
    }

    /**
     * Create an instance of {@link AnalyticsDeviceExtension }
     * 
     */
    public AnalyticsDeviceExtension createAnalyticsDeviceExtension() {
        return new AnalyticsDeviceExtension();
    }

    /**
     * Create an instance of {@link SystemLog }
     * 
     */
    public SystemLog createSystemLog() {
        return new SystemLog();
    }

    /**
     * Create an instance of {@link SupportInformation }
     * 
     */
    public SupportInformation createSupportInformation() {
        return new SupportInformation();
    }

    /**
     * Create an instance of {@link BinaryData }
     * 
     */
    public BinaryData createBinaryData() {
        return new BinaryData();
    }

    /**
     * Create an instance of {@link AttachmentData }
     * 
     */
    public AttachmentData createAttachmentData() {
        return new AttachmentData();
    }

    /**
     * Create an instance of {@link BackupFile }
     * 
     */
    public BackupFile createBackupFile() {
        return new BackupFile();
    }

    /**
     * Create an instance of {@link SystemLogUriList }
     * 
     */
    public SystemLogUriList createSystemLogUriList() {
        return new SystemLogUriList();
    }

    /**
     * Create an instance of {@link SystemLogUri }
     * 
     */
    public SystemLogUri createSystemLogUri() {
        return new SystemLogUri();
    }

    /**
     * Create an instance of {@link SystemDateTime }
     * 
     */
    public SystemDateTime createSystemDateTime() {
        return new SystemDateTime();
    }

    /**
     * Create an instance of {@link SystemDateTimeExtension }
     * 
     */
    public SystemDateTimeExtension createSystemDateTimeExtension() {
        return new SystemDateTimeExtension();
    }

    /**
     * Create an instance of {@link DateTime }
     * 
     */
    public DateTime createDateTime() {
        return new DateTime();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link Time }
     * 
     */
    public Time createTime() {
        return new Time();
    }

    /**
     * Create an instance of {@link TimeZone }
     * 
     */
    public TimeZone createTimeZone() {
        return new TimeZone();
    }

    /**
     * Create an instance of {@link RemoteUser }
     * 
     */
    public RemoteUser createRemoteUser() {
        return new RemoteUser();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link UserExtension }
     * 
     */
    public UserExtension createUserExtension() {
        return new UserExtension();
    }

    /**
     * Create an instance of {@link CertificateGenerationParameters }
     * 
     */
    public CertificateGenerationParameters createCertificateGenerationParameters() {
        return new CertificateGenerationParameters();
    }

    /**
     * Create an instance of {@link CertificateGenerationParametersExtension }
     * 
     */
    public CertificateGenerationParametersExtension createCertificateGenerationParametersExtension() {
        return new CertificateGenerationParametersExtension();
    }

    /**
     * Create an instance of {@link Certificate }
     * 
     */
    public Certificate createCertificate() {
        return new Certificate();
    }

    /**
     * Create an instance of {@link CertificateStatus }
     * 
     */
    public CertificateStatus createCertificateStatus() {
        return new CertificateStatus();
    }

    /**
     * Create an instance of {@link CertificateWithPrivateKey }
     * 
     */
    public CertificateWithPrivateKey createCertificateWithPrivateKey() {
        return new CertificateWithPrivateKey();
    }

    /**
     * Create an instance of {@link CertificateInformation }
     * 
     */
    public CertificateInformation createCertificateInformation() {
        return new CertificateInformation();
    }

    /**
     * Create an instance of {@link CertificateUsage }
     * 
     */
    public CertificateUsage createCertificateUsage() {
        return new CertificateUsage();
    }

    /**
     * Create an instance of {@link CertificateInformationExtension }
     * 
     */
    public CertificateInformationExtension createCertificateInformationExtension() {
        return new CertificateInformationExtension();
    }

    /**
     * Create an instance of {@link Dot1XConfiguration }
     * 
     */
    public Dot1XConfiguration createDot1XConfiguration() {
        return new Dot1XConfiguration();
    }

    /**
     * Create an instance of {@link Dot1XConfigurationExtension }
     * 
     */
    public Dot1XConfigurationExtension createDot1XConfigurationExtension() {
        return new Dot1XConfigurationExtension();
    }

    /**
     * Create an instance of {@link EAPMethodConfiguration }
     * 
     */
    public EAPMethodConfiguration createEAPMethodConfiguration() {
        return new EAPMethodConfiguration();
    }

    /**
     * Create an instance of {@link EapMethodExtension }
     * 
     */
    public EapMethodExtension createEapMethodExtension() {
        return new EapMethodExtension();
    }

    /**
     * Create an instance of {@link TLSConfiguration }
     * 
     */
    public TLSConfiguration createTLSConfiguration() {
        return new TLSConfiguration();
    }

    /**
     * Create an instance of {@link GenericEapPwdConfigurationExtension }
     * 
     */
    public GenericEapPwdConfigurationExtension createGenericEapPwdConfigurationExtension() {
        return new GenericEapPwdConfigurationExtension();
    }

    /**
     * Create an instance of {@link RelayOutputSettings }
     * 
     */
    public RelayOutputSettings createRelayOutputSettings() {
        return new RelayOutputSettings();
    }

    /**
     * Create an instance of {@link RelayOutput }
     * 
     */
    public RelayOutput createRelayOutput() {
        return new RelayOutput();
    }

    /**
     * Create an instance of {@link DigitalInput }
     * 
     */
    public DigitalInput createDigitalInput() {
        return new DigitalInput();
    }

    /**
     * Create an instance of {@link PTZNode }
     * 
     */
    public PTZNode createPTZNode() {
        return new PTZNode();
    }

    /**
     * Create an instance of {@link PTZNodeExtension }
     * 
     */
    public PTZNodeExtension createPTZNodeExtension() {
        return new PTZNodeExtension();
    }

    /**
     * Create an instance of {@link PTZNodeExtension2 }
     * 
     */
    public PTZNodeExtension2 createPTZNodeExtension2() {
        return new PTZNodeExtension2();
    }

    /**
     * Create an instance of {@link PTZPresetTourSupported }
     * 
     */
    public PTZPresetTourSupported createPTZPresetTourSupported() {
        return new PTZPresetTourSupported();
    }

    /**
     * Create an instance of {@link PTZPresetTourSupportedExtension }
     * 
     */
    public PTZPresetTourSupportedExtension createPTZPresetTourSupportedExtension() {
        return new PTZPresetTourSupportedExtension();
    }

    /**
     * Create an instance of {@link PTZConfigurationExtension }
     * 
     */
    public PTZConfigurationExtension createPTZConfigurationExtension() {
        return new PTZConfigurationExtension();
    }

    /**
     * Create an instance of {@link PTZConfigurationExtension2 }
     * 
     */
    public PTZConfigurationExtension2 createPTZConfigurationExtension2() {
        return new PTZConfigurationExtension2();
    }

    /**
     * Create an instance of {@link PTControlDirection }
     * 
     */
    public PTControlDirection createPTControlDirection() {
        return new PTControlDirection();
    }

    /**
     * Create an instance of {@link PTControlDirectionExtension }
     * 
     */
    public PTControlDirectionExtension createPTControlDirectionExtension() {
        return new PTControlDirectionExtension();
    }

    /**
     * Create an instance of {@link EFlip }
     * 
     */
    public EFlip createEFlip() {
        return new EFlip();
    }

    /**
     * Create an instance of {@link Reverse }
     * 
     */
    public Reverse createReverse() {
        return new Reverse();
    }

    /**
     * Create an instance of {@link PTZConfigurationOptions }
     * 
     */
    public PTZConfigurationOptions createPTZConfigurationOptions() {
        return new PTZConfigurationOptions();
    }

    /**
     * Create an instance of {@link PTZConfigurationOptions2 }
     * 
     */
    public PTZConfigurationOptions2 createPTZConfigurationOptions2() {
        return new PTZConfigurationOptions2();
    }

    /**
     * Create an instance of {@link PTControlDirectionOptions }
     * 
     */
    public PTControlDirectionOptions createPTControlDirectionOptions() {
        return new PTControlDirectionOptions();
    }

    /**
     * Create an instance of {@link PTControlDirectionOptionsExtension }
     * 
     */
    public PTControlDirectionOptionsExtension createPTControlDirectionOptionsExtension() {
        return new PTControlDirectionOptionsExtension();
    }

    /**
     * Create an instance of {@link EFlipOptions }
     * 
     */
    public EFlipOptions createEFlipOptions() {
        return new EFlipOptions();
    }

    /**
     * Create an instance of {@link EFlipOptionsExtension }
     * 
     */
    public EFlipOptionsExtension createEFlipOptionsExtension() {
        return new EFlipOptionsExtension();
    }

    /**
     * Create an instance of {@link ReverseOptions }
     * 
     */
    public ReverseOptions createReverseOptions() {
        return new ReverseOptions();
    }

    /**
     * Create an instance of {@link ReverseOptionsExtension }
     * 
     */
    public ReverseOptionsExtension createReverseOptionsExtension() {
        return new ReverseOptionsExtension();
    }

    /**
     * Create an instance of {@link PanTiltLimits }
     * 
     */
    public PanTiltLimits createPanTiltLimits() {
        return new PanTiltLimits();
    }

    /**
     * Create an instance of {@link ZoomLimits }
     * 
     */
    public ZoomLimits createZoomLimits() {
        return new ZoomLimits();
    }

    /**
     * Create an instance of {@link PTZSpaces }
     * 
     */
    public PTZSpaces createPTZSpaces() {
        return new PTZSpaces();
    }

    /**
     * Create an instance of {@link PTZSpacesExtension }
     * 
     */
    public PTZSpacesExtension createPTZSpacesExtension() {
        return new PTZSpacesExtension();
    }

    /**
     * Create an instance of {@link Space2DDescription }
     * 
     */
    public Space2DDescription createSpace2DDescription() {
        return new Space2DDescription();
    }

    /**
     * Create an instance of {@link Space1DDescription }
     * 
     */
    public Space1DDescription createSpace1DDescription() {
        return new Space1DDescription();
    }

    /**
     * Create an instance of {@link PTZSpeed }
     * 
     */
    public PTZSpeed createPTZSpeed() {
        return new PTZSpeed();
    }

    /**
     * Create an instance of {@link PTZPreset }
     * 
     */
    public PTZPreset createPTZPreset() {
        return new PTZPreset();
    }

    /**
     * Create an instance of {@link PresetTour }
     * 
     */
    public PresetTour createPresetTour() {
        return new PresetTour();
    }

    /**
     * Create an instance of {@link PTZPresetTourExtension }
     * 
     */
    public PTZPresetTourExtension createPTZPresetTourExtension() {
        return new PTZPresetTourExtension();
    }

    /**
     * Create an instance of {@link PTZPresetTourSpot }
     * 
     */
    public PTZPresetTourSpot createPTZPresetTourSpot() {
        return new PTZPresetTourSpot();
    }

    /**
     * Create an instance of {@link PTZPresetTourSpotExtension }
     * 
     */
    public PTZPresetTourSpotExtension createPTZPresetTourSpotExtension() {
        return new PTZPresetTourSpotExtension();
    }

    /**
     * Create an instance of {@link PTZPresetTourPresetDetail }
     * 
     */
    public PTZPresetTourPresetDetail createPTZPresetTourPresetDetail() {
        return new PTZPresetTourPresetDetail();
    }

    /**
     * Create an instance of {@link PTZPresetTourTypeExtension }
     * 
     */
    public PTZPresetTourTypeExtension createPTZPresetTourTypeExtension() {
        return new PTZPresetTourTypeExtension();
    }

    /**
     * Create an instance of {@link PTZPresetTourStatus }
     * 
     */
    public PTZPresetTourStatus createPTZPresetTourStatus() {
        return new PTZPresetTourStatus();
    }

    /**
     * Create an instance of {@link PTZPresetTourStatusExtension }
     * 
     */
    public PTZPresetTourStatusExtension createPTZPresetTourStatusExtension() {
        return new PTZPresetTourStatusExtension();
    }

    /**
     * Create an instance of {@link PTZPresetTourStartingCondition }
     * 
     */
    public PTZPresetTourStartingCondition createPTZPresetTourStartingCondition() {
        return new PTZPresetTourStartingCondition();
    }

    /**
     * Create an instance of {@link PTZPresetTourStartingConditionExtension }
     * 
     */
    public PTZPresetTourStartingConditionExtension createPTZPresetTourStartingConditionExtension() {
        return new PTZPresetTourStartingConditionExtension();
    }

    /**
     * Create an instance of {@link PTZPresetTourOptions }
     * 
     */
    public PTZPresetTourOptions createPTZPresetTourOptions() {
        return new PTZPresetTourOptions();
    }

    /**
     * Create an instance of {@link PTZPresetTourSpotOptions }
     * 
     */
    public PTZPresetTourSpotOptions createPTZPresetTourSpotOptions() {
        return new PTZPresetTourSpotOptions();
    }

    /**
     * Create an instance of {@link PTZPresetTourPresetDetailOptions }
     * 
     */
    public PTZPresetTourPresetDetailOptions createPTZPresetTourPresetDetailOptions() {
        return new PTZPresetTourPresetDetailOptions();
    }

    /**
     * Create an instance of {@link PTZPresetTourPresetDetailOptionsExtension }
     * 
     */
    public PTZPresetTourPresetDetailOptionsExtension createPTZPresetTourPresetDetailOptionsExtension() {
        return new PTZPresetTourPresetDetailOptionsExtension();
    }

    /**
     * Create an instance of {@link PTZPresetTourStartingConditionOptions }
     * 
     */
    public PTZPresetTourStartingConditionOptions createPTZPresetTourStartingConditionOptions() {
        return new PTZPresetTourStartingConditionOptions();
    }

    /**
     * Create an instance of {@link PTZPresetTourStartingConditionOptionsExtension }
     * 
     */
    public PTZPresetTourStartingConditionOptionsExtension createPTZPresetTourStartingConditionOptionsExtension() {
        return new PTZPresetTourStartingConditionOptionsExtension();
    }

    /**
     * Create an instance of {@link ImagingStatus }
     * 
     */
    public ImagingStatus createImagingStatus() {
        return new ImagingStatus();
    }

    /**
     * Create an instance of {@link FocusStatus }
     * 
     */
    public FocusStatus createFocusStatus() {
        return new FocusStatus();
    }

    /**
     * Create an instance of {@link FocusConfiguration }
     * 
     */
    public FocusConfiguration createFocusConfiguration() {
        return new FocusConfiguration();
    }

    /**
     * Create an instance of {@link ImagingSettings }
     * 
     */
    public ImagingSettings createImagingSettings() {
        return new ImagingSettings();
    }

    /**
     * Create an instance of {@link ImagingSettingsExtension }
     * 
     */
    public ImagingSettingsExtension createImagingSettingsExtension() {
        return new ImagingSettingsExtension();
    }

    /**
     * Create an instance of {@link Exposure }
     * 
     */
    public Exposure createExposure() {
        return new Exposure();
    }

    /**
     * Create an instance of {@link WideDynamicRange }
     * 
     */
    public WideDynamicRange createWideDynamicRange() {
        return new WideDynamicRange();
    }

    /**
     * Create an instance of {@link BacklightCompensation }
     * 
     */
    public BacklightCompensation createBacklightCompensation() {
        return new BacklightCompensation();
    }

    /**
     * Create an instance of {@link ImagingOptions }
     * 
     */
    public ImagingOptions createImagingOptions() {
        return new ImagingOptions();
    }

    /**
     * Create an instance of {@link WideDynamicRangeOptions }
     * 
     */
    public WideDynamicRangeOptions createWideDynamicRangeOptions() {
        return new WideDynamicRangeOptions();
    }

    /**
     * Create an instance of {@link BacklightCompensationOptions }
     * 
     */
    public BacklightCompensationOptions createBacklightCompensationOptions() {
        return new BacklightCompensationOptions();
    }

    /**
     * Create an instance of {@link FocusOptions }
     * 
     */
    public FocusOptions createFocusOptions() {
        return new FocusOptions();
    }

    /**
     * Create an instance of {@link ExposureOptions }
     * 
     */
    public ExposureOptions createExposureOptions() {
        return new ExposureOptions();
    }

    /**
     * Create an instance of {@link WhiteBalanceOptions }
     * 
     */
    public WhiteBalanceOptions createWhiteBalanceOptions() {
        return new WhiteBalanceOptions();
    }

    /**
     * Create an instance of {@link FocusMove }
     * 
     */
    public FocusMove createFocusMove() {
        return new FocusMove();
    }

    /**
     * Create an instance of {@link AbsoluteFocus }
     * 
     */
    public AbsoluteFocus createAbsoluteFocus() {
        return new AbsoluteFocus();
    }

    /**
     * Create an instance of {@link RelativeFocus }
     * 
     */
    public RelativeFocus createRelativeFocus() {
        return new RelativeFocus();
    }

    /**
     * Create an instance of {@link ContinuousFocus }
     * 
     */
    public ContinuousFocus createContinuousFocus() {
        return new ContinuousFocus();
    }

    /**
     * Create an instance of {@link MoveOptions }
     * 
     */
    public MoveOptions createMoveOptions() {
        return new MoveOptions();
    }

    /**
     * Create an instance of {@link AbsoluteFocusOptions }
     * 
     */
    public AbsoluteFocusOptions createAbsoluteFocusOptions() {
        return new AbsoluteFocusOptions();
    }

    /**
     * Create an instance of {@link RelativeFocusOptions }
     * 
     */
    public RelativeFocusOptions createRelativeFocusOptions() {
        return new RelativeFocusOptions();
    }

    /**
     * Create an instance of {@link ContinuousFocusOptions }
     * 
     */
    public ContinuousFocusOptions createContinuousFocusOptions() {
        return new ContinuousFocusOptions();
    }

    /**
     * Create an instance of {@link WhiteBalance }
     * 
     */
    public WhiteBalance createWhiteBalance() {
        return new WhiteBalance();
    }

    /**
     * Create an instance of {@link ImagingStatus20 }
     * 
     */
    public ImagingStatus20 createImagingStatus20() {
        return new ImagingStatus20();
    }

    /**
     * Create an instance of {@link ImagingStatus20Extension }
     * 
     */
    public ImagingStatus20Extension createImagingStatus20Extension() {
        return new ImagingStatus20Extension();
    }

    /**
     * Create an instance of {@link FocusStatus20 }
     * 
     */
    public FocusStatus20 createFocusStatus20() {
        return new FocusStatus20();
    }

    /**
     * Create an instance of {@link FocusStatus20Extension }
     * 
     */
    public FocusStatus20Extension createFocusStatus20Extension() {
        return new FocusStatus20Extension();
    }

    /**
     * Create an instance of {@link ImagingSettings20 }
     * 
     */
    public ImagingSettings20 createImagingSettings20() {
        return new ImagingSettings20();
    }

    /**
     * Create an instance of {@link ImagingSettingsExtension20 }
     * 
     */
    public ImagingSettingsExtension20 createImagingSettingsExtension20() {
        return new ImagingSettingsExtension20();
    }

    /**
     * Create an instance of {@link ImagingSettingsExtension202 }
     * 
     */
    public ImagingSettingsExtension202 createImagingSettingsExtension202() {
        return new ImagingSettingsExtension202();
    }

    /**
     * Create an instance of {@link ImagingSettingsExtension203 }
     * 
     */
    public ImagingSettingsExtension203 createImagingSettingsExtension203() {
        return new ImagingSettingsExtension203();
    }

    /**
     * Create an instance of {@link ImagingSettingsExtension204 }
     * 
     */
    public ImagingSettingsExtension204 createImagingSettingsExtension204() {
        return new ImagingSettingsExtension204();
    }

    /**
     * Create an instance of {@link ImageStabilization }
     * 
     */
    public ImageStabilization createImageStabilization() {
        return new ImageStabilization();
    }

    /**
     * Create an instance of {@link ImageStabilizationExtension }
     * 
     */
    public ImageStabilizationExtension createImageStabilizationExtension() {
        return new ImageStabilizationExtension();
    }

    /**
     * Create an instance of {@link IrCutFilterAutoAdjustment }
     * 
     */
    public IrCutFilterAutoAdjustment createIrCutFilterAutoAdjustment() {
        return new IrCutFilterAutoAdjustment();
    }

    /**
     * Create an instance of {@link IrCutFilterAutoAdjustmentExtension }
     * 
     */
    public IrCutFilterAutoAdjustmentExtension createIrCutFilterAutoAdjustmentExtension() {
        return new IrCutFilterAutoAdjustmentExtension();
    }

    /**
     * Create an instance of {@link WideDynamicRange20 }
     * 
     */
    public WideDynamicRange20 createWideDynamicRange20() {
        return new WideDynamicRange20();
    }

    /**
     * Create an instance of {@link BacklightCompensation20 }
     * 
     */
    public BacklightCompensation20 createBacklightCompensation20() {
        return new BacklightCompensation20();
    }

    /**
     * Create an instance of {@link Exposure20 }
     * 
     */
    public Exposure20 createExposure20() {
        return new Exposure20();
    }

    /**
     * Create an instance of {@link ToneCompensation }
     * 
     */
    public ToneCompensation createToneCompensation() {
        return new ToneCompensation();
    }

    /**
     * Create an instance of {@link ToneCompensationExtension }
     * 
     */
    public ToneCompensationExtension createToneCompensationExtension() {
        return new ToneCompensationExtension();
    }

    /**
     * Create an instance of {@link Defogging }
     * 
     */
    public Defogging createDefogging() {
        return new Defogging();
    }

    /**
     * Create an instance of {@link DefoggingExtension }
     * 
     */
    public DefoggingExtension createDefoggingExtension() {
        return new DefoggingExtension();
    }

    /**
     * Create an instance of {@link NoiseReduction }
     * 
     */
    public NoiseReduction createNoiseReduction() {
        return new NoiseReduction();
    }

    /**
     * Create an instance of {@link ImagingOptions20 }
     * 
     */
    public ImagingOptions20 createImagingOptions20() {
        return new ImagingOptions20();
    }

    /**
     * Create an instance of {@link ImagingOptions20Extension }
     * 
     */
    public ImagingOptions20Extension createImagingOptions20Extension() {
        return new ImagingOptions20Extension();
    }

    /**
     * Create an instance of {@link ImagingOptions20Extension2 }
     * 
     */
    public ImagingOptions20Extension2 createImagingOptions20Extension2() {
        return new ImagingOptions20Extension2();
    }

    /**
     * Create an instance of {@link ImagingOptions20Extension3 }
     * 
     */
    public ImagingOptions20Extension3 createImagingOptions20Extension3() {
        return new ImagingOptions20Extension3();
    }

    /**
     * Create an instance of {@link ImagingOptions20Extension4 }
     * 
     */
    public ImagingOptions20Extension4 createImagingOptions20Extension4() {
        return new ImagingOptions20Extension4();
    }

    /**
     * Create an instance of {@link ImageStabilizationOptions }
     * 
     */
    public ImageStabilizationOptions createImageStabilizationOptions() {
        return new ImageStabilizationOptions();
    }

    /**
     * Create an instance of {@link ImageStabilizationOptionsExtension }
     * 
     */
    public ImageStabilizationOptionsExtension createImageStabilizationOptionsExtension() {
        return new ImageStabilizationOptionsExtension();
    }

    /**
     * Create an instance of {@link IrCutFilterAutoAdjustmentOptions }
     * 
     */
    public IrCutFilterAutoAdjustmentOptions createIrCutFilterAutoAdjustmentOptions() {
        return new IrCutFilterAutoAdjustmentOptions();
    }

    /**
     * Create an instance of {@link IrCutFilterAutoAdjustmentOptionsExtension }
     * 
     */
    public IrCutFilterAutoAdjustmentOptionsExtension createIrCutFilterAutoAdjustmentOptionsExtension() {
        return new IrCutFilterAutoAdjustmentOptionsExtension();
    }

    /**
     * Create an instance of {@link WideDynamicRangeOptions20 }
     * 
     */
    public WideDynamicRangeOptions20 createWideDynamicRangeOptions20() {
        return new WideDynamicRangeOptions20();
    }

    /**
     * Create an instance of {@link BacklightCompensationOptions20 }
     * 
     */
    public BacklightCompensationOptions20 createBacklightCompensationOptions20() {
        return new BacklightCompensationOptions20();
    }

    /**
     * Create an instance of {@link ExposureOptions20 }
     * 
     */
    public ExposureOptions20 createExposureOptions20() {
        return new ExposureOptions20();
    }

    /**
     * Create an instance of {@link MoveOptions20 }
     * 
     */
    public MoveOptions20 createMoveOptions20() {
        return new MoveOptions20();
    }

    /**
     * Create an instance of {@link RelativeFocusOptions20 }
     * 
     */
    public RelativeFocusOptions20 createRelativeFocusOptions20() {
        return new RelativeFocusOptions20();
    }

    /**
     * Create an instance of {@link WhiteBalance20 }
     * 
     */
    public WhiteBalance20 createWhiteBalance20() {
        return new WhiteBalance20();
    }

    /**
     * Create an instance of {@link WhiteBalance20Extension }
     * 
     */
    public WhiteBalance20Extension createWhiteBalance20Extension() {
        return new WhiteBalance20Extension();
    }

    /**
     * Create an instance of {@link FocusConfiguration20 }
     * 
     */
    public FocusConfiguration20 createFocusConfiguration20() {
        return new FocusConfiguration20();
    }

    /**
     * Create an instance of {@link FocusConfiguration20Extension }
     * 
     */
    public FocusConfiguration20Extension createFocusConfiguration20Extension() {
        return new FocusConfiguration20Extension();
    }

    /**
     * Create an instance of {@link WhiteBalanceOptions20 }
     * 
     */
    public WhiteBalanceOptions20 createWhiteBalanceOptions20() {
        return new WhiteBalanceOptions20();
    }

    /**
     * Create an instance of {@link WhiteBalanceOptions20Extension }
     * 
     */
    public WhiteBalanceOptions20Extension createWhiteBalanceOptions20Extension() {
        return new WhiteBalanceOptions20Extension();
    }

    /**
     * Create an instance of {@link FocusOptions20 }
     * 
     */
    public FocusOptions20 createFocusOptions20() {
        return new FocusOptions20();
    }

    /**
     * Create an instance of {@link FocusOptions20Extension }
     * 
     */
    public FocusOptions20Extension createFocusOptions20Extension() {
        return new FocusOptions20Extension();
    }

    /**
     * Create an instance of {@link ToneCompensationOptions }
     * 
     */
    public ToneCompensationOptions createToneCompensationOptions() {
        return new ToneCompensationOptions();
    }

    /**
     * Create an instance of {@link DefoggingOptions }
     * 
     */
    public DefoggingOptions createDefoggingOptions() {
        return new DefoggingOptions();
    }

    /**
     * Create an instance of {@link NoiseReductionOptions }
     * 
     */
    public NoiseReductionOptions createNoiseReductionOptions() {
        return new NoiseReductionOptions();
    }

    /**
     * Create an instance of {@link ItemListExtension }
     * 
     */
    public ItemListExtension createItemListExtension() {
        return new ItemListExtension();
    }

    /**
     * Create an instance of {@link MessageDescription }
     * 
     */
    public MessageDescription createMessageDescription() {
        return new MessageDescription();
    }

    /**
     * Create an instance of {@link MessageDescriptionExtension }
     * 
     */
    public MessageDescriptionExtension createMessageDescriptionExtension() {
        return new MessageDescriptionExtension();
    }

    /**
     * Create an instance of {@link ItemListDescriptionExtension }
     * 
     */
    public ItemListDescriptionExtension createItemListDescriptionExtension() {
        return new ItemListDescriptionExtension();
    }

    /**
     * Create an instance of {@link AnalyticsEngineConfiguration }
     * 
     */
    public AnalyticsEngineConfiguration createAnalyticsEngineConfiguration() {
        return new AnalyticsEngineConfiguration();
    }

    /**
     * Create an instance of {@link AnalyticsEngineConfigurationExtension }
     * 
     */
    public AnalyticsEngineConfigurationExtension createAnalyticsEngineConfigurationExtension() {
        return new AnalyticsEngineConfigurationExtension();
    }

    /**
     * Create an instance of {@link RuleEngineConfiguration }
     * 
     */
    public RuleEngineConfiguration createRuleEngineConfiguration() {
        return new RuleEngineConfiguration();
    }

    /**
     * Create an instance of {@link RuleEngineConfigurationExtension }
     * 
     */
    public RuleEngineConfigurationExtension createRuleEngineConfigurationExtension() {
        return new RuleEngineConfigurationExtension();
    }

    /**
     * Create an instance of {@link Config }
     * 
     */
    public Config createConfig() {
        return new Config();
    }

    /**
     * Create an instance of {@link ConfigDescriptionExtension }
     * 
     */
    public ConfigDescriptionExtension createConfigDescriptionExtension() {
        return new ConfigDescriptionExtension();
    }

    /**
     * Create an instance of {@link SupportedRules }
     * 
     */
    public SupportedRules createSupportedRules() {
        return new SupportedRules();
    }

    /**
     * Create an instance of {@link SupportedRulesExtension }
     * 
     */
    public SupportedRulesExtension createSupportedRulesExtension() {
        return new SupportedRulesExtension();
    }

    /**
     * Create an instance of {@link SupportedAnalyticsModules }
     * 
     */
    public SupportedAnalyticsModules createSupportedAnalyticsModules() {
        return new SupportedAnalyticsModules();
    }

    /**
     * Create an instance of {@link SupportedAnalyticsModulesExtension }
     * 
     */
    public SupportedAnalyticsModulesExtension createSupportedAnalyticsModulesExtension() {
        return new SupportedAnalyticsModulesExtension();
    }

    /**
     * Create an instance of {@link PolylineArray }
     * 
     */
    public PolylineArray createPolylineArray() {
        return new PolylineArray();
    }

    /**
     * Create an instance of {@link PolylineArrayExtension }
     * 
     */
    public PolylineArrayExtension createPolylineArrayExtension() {
        return new PolylineArrayExtension();
    }

    /**
     * Create an instance of {@link PolylineArrayConfiguration }
     * 
     */
    public PolylineArrayConfiguration createPolylineArrayConfiguration() {
        return new PolylineArrayConfiguration();
    }

    /**
     * Create an instance of {@link MotionExpression }
     * 
     */
    public MotionExpression createMotionExpression() {
        return new MotionExpression();
    }

    /**
     * Create an instance of {@link MotionExpressionConfiguration }
     * 
     */
    public MotionExpressionConfiguration createMotionExpressionConfiguration() {
        return new MotionExpressionConfiguration();
    }

    /**
     * Create an instance of {@link CellLayout }
     * 
     */
    public CellLayout createCellLayout() {
        return new CellLayout();
    }

    /**
     * Create an instance of {@link PaneConfiguration }
     * 
     */
    public PaneConfiguration createPaneConfiguration() {
        return new PaneConfiguration();
    }

    /**
     * Create an instance of {@link PaneLayout }
     * 
     */
    public PaneLayout createPaneLayout() {
        return new PaneLayout();
    }

    /**
     * Create an instance of {@link Layout }
     * 
     */
    public Layout createLayout() {
        return new Layout();
    }

    /**
     * Create an instance of {@link LayoutExtension }
     * 
     */
    public LayoutExtension createLayoutExtension() {
        return new LayoutExtension();
    }

    /**
     * Create an instance of {@link CodingCapabilities }
     * 
     */
    public CodingCapabilities createCodingCapabilities() {
        return new CodingCapabilities();
    }

    /**
     * Create an instance of {@link LayoutOptions }
     * 
     */
    public LayoutOptions createLayoutOptions() {
        return new LayoutOptions();
    }

    /**
     * Create an instance of {@link LayoutOptionsExtension }
     * 
     */
    public LayoutOptionsExtension createLayoutOptionsExtension() {
        return new LayoutOptionsExtension();
    }

    /**
     * Create an instance of {@link PaneLayoutOptions }
     * 
     */
    public PaneLayoutOptions createPaneLayoutOptions() {
        return new PaneLayoutOptions();
    }

    /**
     * Create an instance of {@link PaneOptionExtension }
     * 
     */
    public PaneOptionExtension createPaneOptionExtension() {
        return new PaneOptionExtension();
    }

    /**
     * Create an instance of {@link Receiver }
     * 
     */
    public Receiver createReceiver() {
        return new Receiver();
    }

    /**
     * Create an instance of {@link ReceiverConfiguration }
     * 
     */
    public ReceiverConfiguration createReceiverConfiguration() {
        return new ReceiverConfiguration();
    }

    /**
     * Create an instance of {@link ReceiverStateInformation }
     * 
     */
    public ReceiverStateInformation createReceiverStateInformation() {
        return new ReceiverStateInformation();
    }

    /**
     * Create an instance of {@link SourceReference }
     * 
     */
    public SourceReference createSourceReference() {
        return new SourceReference();
    }

    /**
     * Create an instance of {@link DateTimeRange }
     * 
     */
    public DateTimeRange createDateTimeRange() {
        return new DateTimeRange();
    }

    /**
     * Create an instance of {@link RecordingSummary }
     * 
     */
    public RecordingSummary createRecordingSummary() {
        return new RecordingSummary();
    }

    /**
     * Create an instance of {@link SearchScope }
     * 
     */
    public SearchScope createSearchScope() {
        return new SearchScope();
    }

    /**
     * Create an instance of {@link SearchScopeExtension }
     * 
     */
    public SearchScopeExtension createSearchScopeExtension() {
        return new SearchScopeExtension();
    }

    /**
     * Create an instance of {@link EventFilter }
     * 
     */
    public EventFilter createEventFilter() {
        return new EventFilter();
    }

    /**
     * Create an instance of {@link PTZPositionFilter }
     * 
     */
    public PTZPositionFilter createPTZPositionFilter() {
        return new PTZPositionFilter();
    }

    /**
     * Create an instance of {@link MetadataFilter }
     * 
     */
    public MetadataFilter createMetadataFilter() {
        return new MetadataFilter();
    }

    /**
     * Create an instance of {@link FindRecordingResultList }
     * 
     */
    public FindRecordingResultList createFindRecordingResultList() {
        return new FindRecordingResultList();
    }

    /**
     * Create an instance of {@link FindEventResultList }
     * 
     */
    public FindEventResultList createFindEventResultList() {
        return new FindEventResultList();
    }

    /**
     * Create an instance of {@link FindEventResult }
     * 
     */
    public FindEventResult createFindEventResult() {
        return new FindEventResult();
    }

    /**
     * Create an instance of {@link FindPTZPositionResultList }
     * 
     */
    public FindPTZPositionResultList createFindPTZPositionResultList() {
        return new FindPTZPositionResultList();
    }

    /**
     * Create an instance of {@link FindPTZPositionResult }
     * 
     */
    public FindPTZPositionResult createFindPTZPositionResult() {
        return new FindPTZPositionResult();
    }

    /**
     * Create an instance of {@link FindMetadataResultList }
     * 
     */
    public FindMetadataResultList createFindMetadataResultList() {
        return new FindMetadataResultList();
    }

    /**
     * Create an instance of {@link FindMetadataResult }
     * 
     */
    public FindMetadataResult createFindMetadataResult() {
        return new FindMetadataResult();
    }

    /**
     * Create an instance of {@link RecordingInformation }
     * 
     */
    public RecordingInformation createRecordingInformation() {
        return new RecordingInformation();
    }

    /**
     * Create an instance of {@link RecordingSourceInformation }
     * 
     */
    public RecordingSourceInformation createRecordingSourceInformation() {
        return new RecordingSourceInformation();
    }

    /**
     * Create an instance of {@link TrackInformation }
     * 
     */
    public TrackInformation createTrackInformation() {
        return new TrackInformation();
    }

    /**
     * Create an instance of {@link MediaAttributes }
     * 
     */
    public MediaAttributes createMediaAttributes() {
        return new MediaAttributes();
    }

    /**
     * Create an instance of {@link TrackAttributes }
     * 
     */
    public TrackAttributes createTrackAttributes() {
        return new TrackAttributes();
    }

    /**
     * Create an instance of {@link TrackAttributesExtension }
     * 
     */
    public TrackAttributesExtension createTrackAttributesExtension() {
        return new TrackAttributesExtension();
    }

    /**
     * Create an instance of {@link VideoAttributes }
     * 
     */
    public VideoAttributes createVideoAttributes() {
        return new VideoAttributes();
    }

    /**
     * Create an instance of {@link AudioAttributes }
     * 
     */
    public AudioAttributes createAudioAttributes() {
        return new AudioAttributes();
    }

    /**
     * Create an instance of {@link MetadataAttributes }
     * 
     */
    public MetadataAttributes createMetadataAttributes() {
        return new MetadataAttributes();
    }

    /**
     * Create an instance of {@link RecordingConfiguration }
     * 
     */
    public RecordingConfiguration createRecordingConfiguration() {
        return new RecordingConfiguration();
    }

    /**
     * Create an instance of {@link TrackConfiguration }
     * 
     */
    public TrackConfiguration createTrackConfiguration() {
        return new TrackConfiguration();
    }

    /**
     * Create an instance of {@link GetRecordingsResponseItem }
     * 
     */
    public GetRecordingsResponseItem createGetRecordingsResponseItem() {
        return new GetRecordingsResponseItem();
    }

    /**
     * Create an instance of {@link GetTracksResponseList }
     * 
     */
    public GetTracksResponseList createGetTracksResponseList() {
        return new GetTracksResponseList();
    }

    /**
     * Create an instance of {@link GetTracksResponseItem }
     * 
     */
    public GetTracksResponseItem createGetTracksResponseItem() {
        return new GetTracksResponseItem();
    }

    /**
     * Create an instance of {@link RecordingJobConfiguration }
     * 
     */
    public RecordingJobConfiguration createRecordingJobConfiguration() {
        return new RecordingJobConfiguration();
    }

    /**
     * Create an instance of {@link RecordingJobConfigurationExtension }
     * 
     */
    public RecordingJobConfigurationExtension createRecordingJobConfigurationExtension() {
        return new RecordingJobConfigurationExtension();
    }

    /**
     * Create an instance of {@link RecordingJobSource }
     * 
     */
    public RecordingJobSource createRecordingJobSource() {
        return new RecordingJobSource();
    }

    /**
     * Create an instance of {@link RecordingJobSourceExtension }
     * 
     */
    public RecordingJobSourceExtension createRecordingJobSourceExtension() {
        return new RecordingJobSourceExtension();
    }

    /**
     * Create an instance of {@link RecordingJobTrack }
     * 
     */
    public RecordingJobTrack createRecordingJobTrack() {
        return new RecordingJobTrack();
    }

    /**
     * Create an instance of {@link RecordingJobStateInformation }
     * 
     */
    public RecordingJobStateInformation createRecordingJobStateInformation() {
        return new RecordingJobStateInformation();
    }

    /**
     * Create an instance of {@link RecordingJobStateInformationExtension }
     * 
     */
    public RecordingJobStateInformationExtension createRecordingJobStateInformationExtension() {
        return new RecordingJobStateInformationExtension();
    }

    /**
     * Create an instance of {@link RecordingJobStateSource }
     * 
     */
    public RecordingJobStateSource createRecordingJobStateSource() {
        return new RecordingJobStateSource();
    }

    /**
     * Create an instance of {@link RecordingJobStateTracks }
     * 
     */
    public RecordingJobStateTracks createRecordingJobStateTracks() {
        return new RecordingJobStateTracks();
    }

    /**
     * Create an instance of {@link RecordingJobStateTrack }
     * 
     */
    public RecordingJobStateTrack createRecordingJobStateTrack() {
        return new RecordingJobStateTrack();
    }

    /**
     * Create an instance of {@link GetRecordingJobsResponseItem }
     * 
     */
    public GetRecordingJobsResponseItem createGetRecordingJobsResponseItem() {
        return new GetRecordingJobsResponseItem();
    }

    /**
     * Create an instance of {@link ReplayConfiguration }
     * 
     */
    public ReplayConfiguration createReplayConfiguration() {
        return new ReplayConfiguration();
    }

    /**
     * Create an instance of {@link AnalyticsEngine }
     * 
     */
    public AnalyticsEngine createAnalyticsEngine() {
        return new AnalyticsEngine();
    }

    /**
     * Create an instance of {@link AnalyticsDeviceEngineConfiguration }
     * 
     */
    public AnalyticsDeviceEngineConfiguration createAnalyticsDeviceEngineConfiguration() {
        return new AnalyticsDeviceEngineConfiguration();
    }

    /**
     * Create an instance of {@link AnalyticsDeviceEngineConfigurationExtension }
     * 
     */
    public AnalyticsDeviceEngineConfigurationExtension createAnalyticsDeviceEngineConfigurationExtension() {
        return new AnalyticsDeviceEngineConfigurationExtension();
    }

    /**
     * Create an instance of {@link EngineConfiguration }
     * 
     */
    public EngineConfiguration createEngineConfiguration() {
        return new EngineConfiguration();
    }

    /**
     * Create an instance of {@link AnalyticsEngineInputInfo }
     * 
     */
    public AnalyticsEngineInputInfo createAnalyticsEngineInputInfo() {
        return new AnalyticsEngineInputInfo();
    }

    /**
     * Create an instance of {@link AnalyticsEngineInputInfoExtension }
     * 
     */
    public AnalyticsEngineInputInfoExtension createAnalyticsEngineInputInfoExtension() {
        return new AnalyticsEngineInputInfoExtension();
    }

    /**
     * Create an instance of {@link AnalyticsEngineInput }
     * 
     */
    public AnalyticsEngineInput createAnalyticsEngineInput() {
        return new AnalyticsEngineInput();
    }

    /**
     * Create an instance of {@link SourceIdentification }
     * 
     */
    public SourceIdentification createSourceIdentification() {
        return new SourceIdentification();
    }

    /**
     * Create an instance of {@link SourceIdentificationExtension }
     * 
     */
    public SourceIdentificationExtension createSourceIdentificationExtension() {
        return new SourceIdentificationExtension();
    }

    /**
     * Create an instance of {@link MetadataInput }
     * 
     */
    public MetadataInput createMetadataInput() {
        return new MetadataInput();
    }

    /**
     * Create an instance of {@link MetadataInputExtension }
     * 
     */
    public MetadataInputExtension createMetadataInputExtension() {
        return new MetadataInputExtension();
    }

    /**
     * Create an instance of {@link AnalyticsEngineControl }
     * 
     */
    public AnalyticsEngineControl createAnalyticsEngineControl() {
        return new AnalyticsEngineControl();
    }

    /**
     * Create an instance of {@link AnalyticsStateInformation }
     * 
     */
    public AnalyticsStateInformation createAnalyticsStateInformation() {
        return new AnalyticsStateInformation();
    }

    /**
     * Create an instance of {@link AnalyticsState }
     * 
     */
    public AnalyticsState createAnalyticsState() {
        return new AnalyticsState();
    }

    /**
     * Create an instance of {@link ActionEngineEventPayload }
     * 
     */
    public ActionEngineEventPayload createActionEngineEventPayload() {
        return new ActionEngineEventPayload();
    }

    /**
     * Create an instance of {@link ActionEngineEventPayloadExtension }
     * 
     */
    public ActionEngineEventPayloadExtension createActionEngineEventPayloadExtension() {
        return new ActionEngineEventPayloadExtension();
    }

    /**
     * Create an instance of {@link AudioClassCandidate }
     * 
     */
    public AudioClassCandidate createAudioClassCandidate() {
        return new AudioClassCandidate();
    }

    /**
     * Create an instance of {@link AudioClassDescriptor }
     * 
     */
    public AudioClassDescriptor createAudioClassDescriptor() {
        return new AudioClassDescriptor();
    }

    /**
     * Create an instance of {@link AudioClassDescriptorExtension }
     * 
     */
    public AudioClassDescriptorExtension createAudioClassDescriptorExtension() {
        return new AudioClassDescriptorExtension();
    }

    /**
     * Create an instance of {@link ActiveConnection }
     * 
     */
    public ActiveConnection createActiveConnection() {
        return new ActiveConnection();
    }

    /**
     * Create an instance of {@link ProfileStatus }
     * 
     */
    public ProfileStatus createProfileStatus() {
        return new ProfileStatus();
    }

    /**
     * Create an instance of {@link ProfileStatusExtension }
     * 
     */
    public ProfileStatusExtension createProfileStatusExtension() {
        return new ProfileStatusExtension();
    }

    /**
     * Create an instance of {@link OSDReference }
     * 
     */
    public OSDReference createOSDReference() {
        return new OSDReference();
    }

    /**
     * Create an instance of {@link OSDPosConfiguration }
     * 
     */
    public OSDPosConfiguration createOSDPosConfiguration() {
        return new OSDPosConfiguration();
    }

    /**
     * Create an instance of {@link OSDPosConfigurationExtension }
     * 
     */
    public OSDPosConfigurationExtension createOSDPosConfigurationExtension() {
        return new OSDPosConfigurationExtension();
    }

    /**
     * Create an instance of {@link OSDColor }
     * 
     */
    public OSDColor createOSDColor() {
        return new OSDColor();
    }

    /**
     * Create an instance of {@link OSDTextConfiguration }
     * 
     */
    public OSDTextConfiguration createOSDTextConfiguration() {
        return new OSDTextConfiguration();
    }

    /**
     * Create an instance of {@link OSDTextConfigurationExtension }
     * 
     */
    public OSDTextConfigurationExtension createOSDTextConfigurationExtension() {
        return new OSDTextConfigurationExtension();
    }

    /**
     * Create an instance of {@link OSDImgConfiguration }
     * 
     */
    public OSDImgConfiguration createOSDImgConfiguration() {
        return new OSDImgConfiguration();
    }

    /**
     * Create an instance of {@link OSDImgConfigurationExtension }
     * 
     */
    public OSDImgConfigurationExtension createOSDImgConfigurationExtension() {
        return new OSDImgConfigurationExtension();
    }

    /**
     * Create an instance of {@link ColorspaceRange }
     * 
     */
    public ColorspaceRange createColorspaceRange() {
        return new ColorspaceRange();
    }

    /**
     * Create an instance of {@link ColorOptions }
     * 
     */
    public ColorOptions createColorOptions() {
        return new ColorOptions();
    }

    /**
     * Create an instance of {@link OSDColorOptions }
     * 
     */
    public OSDColorOptions createOSDColorOptions() {
        return new OSDColorOptions();
    }

    /**
     * Create an instance of {@link OSDColorOptionsExtension }
     * 
     */
    public OSDColorOptionsExtension createOSDColorOptionsExtension() {
        return new OSDColorOptionsExtension();
    }

    /**
     * Create an instance of {@link OSDTextOptions }
     * 
     */
    public OSDTextOptions createOSDTextOptions() {
        return new OSDTextOptions();
    }

    /**
     * Create an instance of {@link OSDTextOptionsExtension }
     * 
     */
    public OSDTextOptionsExtension createOSDTextOptionsExtension() {
        return new OSDTextOptionsExtension();
    }

    /**
     * Create an instance of {@link OSDImgOptions }
     * 
     */
    public OSDImgOptions createOSDImgOptions() {
        return new OSDImgOptions();
    }

    /**
     * Create an instance of {@link OSDImgOptionsExtension }
     * 
     */
    public OSDImgOptionsExtension createOSDImgOptionsExtension() {
        return new OSDImgOptionsExtension();
    }

    /**
     * Create an instance of {@link OSDConfiguration }
     * 
     */
    public OSDConfiguration createOSDConfiguration() {
        return new OSDConfiguration();
    }

    /**
     * Create an instance of {@link OSDConfigurationExtension }
     * 
     */
    public OSDConfigurationExtension createOSDConfigurationExtension() {
        return new OSDConfigurationExtension();
    }

    /**
     * Create an instance of {@link MaximumNumberOfOSDs }
     * 
     */
    public MaximumNumberOfOSDs createMaximumNumberOfOSDs() {
        return new MaximumNumberOfOSDs();
    }

    /**
     * Create an instance of {@link OSDConfigurationOptions }
     * 
     */
    public OSDConfigurationOptions createOSDConfigurationOptions() {
        return new OSDConfigurationOptions();
    }

    /**
     * Create an instance of {@link OSDConfigurationOptionsExtension }
     * 
     */
    public OSDConfigurationOptionsExtension createOSDConfigurationOptionsExtension() {
        return new OSDConfigurationOptionsExtension();
    }

    /**
     * Create an instance of {@link FileProgress }
     * 
     */
    public FileProgress createFileProgress() {
        return new FileProgress();
    }

    /**
     * Create an instance of {@link ArrayOfFileProgress }
     * 
     */
    public ArrayOfFileProgress createArrayOfFileProgress() {
        return new ArrayOfFileProgress();
    }

    /**
     * Create an instance of {@link ArrayOfFileProgressExtension }
     * 
     */
    public ArrayOfFileProgressExtension createArrayOfFileProgressExtension() {
        return new ArrayOfFileProgressExtension();
    }

    /**
     * Create an instance of {@link StorageReferencePath }
     * 
     */
    public StorageReferencePath createStorageReferencePath() {
        return new StorageReferencePath();
    }

    /**
     * Create an instance of {@link StorageReferencePathExtension }
     * 
     */
    public StorageReferencePathExtension createStorageReferencePathExtension() {
        return new StorageReferencePathExtension();
    }

    /**
     * Create an instance of {@link Base64Binary }
     * 
     */
    public Base64Binary createBase64Binary() {
        return new Base64Binary();
    }

    /**
     * Create an instance of {@link HexBinary }
     * 
     */
    public HexBinary createHexBinary() {
        return new HexBinary();
    }

    /**
     * Create an instance of {@link Envelope }
     * 
     */
    public Envelope createEnvelope() {
        return new Envelope();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link Body }
     * 
     */
    public Body createBody() {
        return new Body();
    }

    /**
     * Create an instance of {@link Fault }
     * 
     */
    public Fault createFault() {
        return new Fault();
    }

    /**
     * Create an instance of {@link NotUnderstoodType }
     * 
     */
    public NotUnderstoodType createNotUnderstoodType() {
        return new NotUnderstoodType();
    }

    /**
     * Create an instance of {@link UpgradeType }
     * 
     */
    public UpgradeType createUpgradeType() {
        return new UpgradeType();
    }

    /**
     * Create an instance of {@link Faultreason }
     * 
     */
    public Faultreason createFaultreason() {
        return new Faultreason();
    }

    /**
     * Create an instance of {@link Reasontext }
     * 
     */
    public Reasontext createReasontext() {
        return new Reasontext();
    }

    /**
     * Create an instance of {@link Faultcode }
     * 
     */
    public Faultcode createFaultcode() {
        return new Faultcode();
    }

    /**
     * Create an instance of {@link Subcode }
     * 
     */
    public Subcode createSubcode() {
        return new Subcode();
    }

    /**
     * Create an instance of {@link Detail }
     * 
     */
    public Detail createDetail() {
        return new Detail();
    }

    /**
     * Create an instance of {@link SupportedEnvType }
     * 
     */
    public SupportedEnvType createSupportedEnvType() {
        return new SupportedEnvType();
    }

    /**
     * Create an instance of {@link GetServices }
     * 
     */
    public GetServices createGetServices() {
        return new GetServices();
    }

    /**
     * Create an instance of {@link GetServicesResponse }
     * 
     */
    public GetServicesResponse createGetServicesResponse() {
        return new GetServicesResponse();
    }

    /**
     * Create an instance of {@link GetServiceCapabilities }
     * 
     */
    public GetServiceCapabilities createGetServiceCapabilities() {
        return new GetServiceCapabilities();
    }

    /**
     * Create an instance of {@link GetServiceCapabilitiesResponse }
     * 
     */
    public GetServiceCapabilitiesResponse createGetServiceCapabilitiesResponse() {
        return new GetServiceCapabilitiesResponse();
    }

    /**
     * Create an instance of {@link DeviceServiceCapabilities }
     * 
     */
    public DeviceServiceCapabilities createDeviceServiceCapabilities() {
        return new DeviceServiceCapabilities();
    }

    /**
     * Create an instance of {@link GetDeviceInformation }
     * 
     */
    public GetDeviceInformation createGetDeviceInformation() {
        return new GetDeviceInformation();
    }

    /**
     * Create an instance of {@link GetDeviceInformationResponse }
     * 
     */
    public GetDeviceInformationResponse createGetDeviceInformationResponse() {
        return new GetDeviceInformationResponse();
    }

    /**
     * Create an instance of {@link SetSystemDateAndTime }
     * 
     */
    public SetSystemDateAndTime createSetSystemDateAndTime() {
        return new SetSystemDateAndTime();
    }

    /**
     * Create an instance of {@link SetSystemDateAndTimeResponse }
     * 
     */
    public SetSystemDateAndTimeResponse createSetSystemDateAndTimeResponse() {
        return new SetSystemDateAndTimeResponse();
    }

    /**
     * Create an instance of {@link GetSystemDateAndTime }
     * 
     */
    public GetSystemDateAndTime createGetSystemDateAndTime() {
        return new GetSystemDateAndTime();
    }

    /**
     * Create an instance of {@link GetSystemDateAndTimeResponse }
     * 
     */
    public GetSystemDateAndTimeResponse createGetSystemDateAndTimeResponse() {
        return new GetSystemDateAndTimeResponse();
    }

    /**
     * Create an instance of {@link SetSystemFactoryDefault }
     * 
     */
    public SetSystemFactoryDefault createSetSystemFactoryDefault() {
        return new SetSystemFactoryDefault();
    }

    /**
     * Create an instance of {@link SetSystemFactoryDefaultResponse }
     * 
     */
    public SetSystemFactoryDefaultResponse createSetSystemFactoryDefaultResponse() {
        return new SetSystemFactoryDefaultResponse();
    }

    /**
     * Create an instance of {@link UpgradeSystemFirmware }
     * 
     */
    public UpgradeSystemFirmware createUpgradeSystemFirmware() {
        return new UpgradeSystemFirmware();
    }

    /**
     * Create an instance of {@link UpgradeSystemFirmwareResponse }
     * 
     */
    public UpgradeSystemFirmwareResponse createUpgradeSystemFirmwareResponse() {
        return new UpgradeSystemFirmwareResponse();
    }

    /**
     * Create an instance of {@link SystemReboot }
     * 
     */
    public SystemReboot createSystemReboot() {
        return new SystemReboot();
    }

    /**
     * Create an instance of {@link SystemRebootResponse }
     * 
     */
    public SystemRebootResponse createSystemRebootResponse() {
        return new SystemRebootResponse();
    }

    /**
     * Create an instance of {@link RestoreSystem }
     * 
     */
    public RestoreSystem createRestoreSystem() {
        return new RestoreSystem();
    }

    /**
     * Create an instance of {@link RestoreSystemResponse }
     * 
     */
    public RestoreSystemResponse createRestoreSystemResponse() {
        return new RestoreSystemResponse();
    }

    /**
     * Create an instance of {@link GetSystemBackup }
     * 
     */
    public GetSystemBackup createGetSystemBackup() {
        return new GetSystemBackup();
    }

    /**
     * Create an instance of {@link GetSystemBackupResponse }
     * 
     */
    public GetSystemBackupResponse createGetSystemBackupResponse() {
        return new GetSystemBackupResponse();
    }

    /**
     * Create an instance of {@link GetSystemSupportInformation }
     * 
     */
    public GetSystemSupportInformation createGetSystemSupportInformation() {
        return new GetSystemSupportInformation();
    }

    /**
     * Create an instance of {@link GetSystemSupportInformationResponse }
     * 
     */
    public GetSystemSupportInformationResponse createGetSystemSupportInformationResponse() {
        return new GetSystemSupportInformationResponse();
    }

    /**
     * Create an instance of {@link GetSystemLog }
     * 
     */
    public GetSystemLog createGetSystemLog() {
        return new GetSystemLog();
    }

    /**
     * Create an instance of {@link GetSystemLogResponse }
     * 
     */
    public GetSystemLogResponse createGetSystemLogResponse() {
        return new GetSystemLogResponse();
    }

    /**
     * Create an instance of {@link GetScopes }
     * 
     */
    public GetScopes createGetScopes() {
        return new GetScopes();
    }

    /**
     * Create an instance of {@link GetScopesResponse }
     * 
     */
    public GetScopesResponse createGetScopesResponse() {
        return new GetScopesResponse();
    }

    /**
     * Create an instance of {@link SetScopes }
     * 
     */
    public SetScopes createSetScopes() {
        return new SetScopes();
    }

    /**
     * Create an instance of {@link SetScopesResponse }
     * 
     */
    public SetScopesResponse createSetScopesResponse() {
        return new SetScopesResponse();
    }

    /**
     * Create an instance of {@link AddScopes }
     * 
     */
    public AddScopes createAddScopes() {
        return new AddScopes();
    }

    /**
     * Create an instance of {@link AddScopesResponse }
     * 
     */
    public AddScopesResponse createAddScopesResponse() {
        return new AddScopesResponse();
    }

    /**
     * Create an instance of {@link RemoveScopes }
     * 
     */
    public RemoveScopes createRemoveScopes() {
        return new RemoveScopes();
    }

    /**
     * Create an instance of {@link RemoveScopesResponse }
     * 
     */
    public RemoveScopesResponse createRemoveScopesResponse() {
        return new RemoveScopesResponse();
    }

    /**
     * Create an instance of {@link GetDiscoveryMode }
     * 
     */
    public GetDiscoveryMode createGetDiscoveryMode() {
        return new GetDiscoveryMode();
    }

    /**
     * Create an instance of {@link GetDiscoveryModeResponse }
     * 
     */
    public GetDiscoveryModeResponse createGetDiscoveryModeResponse() {
        return new GetDiscoveryModeResponse();
    }

    /**
     * Create an instance of {@link SetDiscoveryMode }
     * 
     */
    public SetDiscoveryMode createSetDiscoveryMode() {
        return new SetDiscoveryMode();
    }

    /**
     * Create an instance of {@link SetDiscoveryModeResponse }
     * 
     */
    public SetDiscoveryModeResponse createSetDiscoveryModeResponse() {
        return new SetDiscoveryModeResponse();
    }

    /**
     * Create an instance of {@link GetRemoteDiscoveryMode }
     * 
     */
    public GetRemoteDiscoveryMode createGetRemoteDiscoveryMode() {
        return new GetRemoteDiscoveryMode();
    }

    /**
     * Create an instance of {@link GetRemoteDiscoveryModeResponse }
     * 
     */
    public GetRemoteDiscoveryModeResponse createGetRemoteDiscoveryModeResponse() {
        return new GetRemoteDiscoveryModeResponse();
    }

    /**
     * Create an instance of {@link SetRemoteDiscoveryMode }
     * 
     */
    public SetRemoteDiscoveryMode createSetRemoteDiscoveryMode() {
        return new SetRemoteDiscoveryMode();
    }

    /**
     * Create an instance of {@link SetRemoteDiscoveryModeResponse }
     * 
     */
    public SetRemoteDiscoveryModeResponse createSetRemoteDiscoveryModeResponse() {
        return new SetRemoteDiscoveryModeResponse();
    }

    /**
     * Create an instance of {@link GetDPAddresses }
     * 
     */
    public GetDPAddresses createGetDPAddresses() {
        return new GetDPAddresses();
    }

    /**
     * Create an instance of {@link GetDPAddressesResponse }
     * 
     */
    public GetDPAddressesResponse createGetDPAddressesResponse() {
        return new GetDPAddressesResponse();
    }

    /**
     * Create an instance of {@link SetDPAddresses }
     * 
     */
    public SetDPAddresses createSetDPAddresses() {
        return new SetDPAddresses();
    }

    /**
     * Create an instance of {@link SetDPAddressesResponse }
     * 
     */
    public SetDPAddressesResponse createSetDPAddressesResponse() {
        return new SetDPAddressesResponse();
    }

    /**
     * Create an instance of {@link GetEndpointReference }
     * 
     */
    public GetEndpointReference createGetEndpointReference() {
        return new GetEndpointReference();
    }

    /**
     * Create an instance of {@link GetEndpointReferenceResponse }
     * 
     */
    public GetEndpointReferenceResponse createGetEndpointReferenceResponse() {
        return new GetEndpointReferenceResponse();
    }

    /**
     * Create an instance of {@link GetRemoteUser }
     * 
     */
    public GetRemoteUser createGetRemoteUser() {
        return new GetRemoteUser();
    }

    /**
     * Create an instance of {@link GetRemoteUserResponse }
     * 
     */
    public GetRemoteUserResponse createGetRemoteUserResponse() {
        return new GetRemoteUserResponse();
    }

    /**
     * Create an instance of {@link SetRemoteUser }
     * 
     */
    public SetRemoteUser createSetRemoteUser() {
        return new SetRemoteUser();
    }

    /**
     * Create an instance of {@link SetRemoteUserResponse }
     * 
     */
    public SetRemoteUserResponse createSetRemoteUserResponse() {
        return new SetRemoteUserResponse();
    }

    /**
     * Create an instance of {@link GetUsers }
     * 
     */
    public GetUsers createGetUsers() {
        return new GetUsers();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link CreateUsers }
     * 
     */
    public CreateUsers createCreateUsers() {
        return new CreateUsers();
    }

    /**
     * Create an instance of {@link CreateUsersResponse }
     * 
     */
    public CreateUsersResponse createCreateUsersResponse() {
        return new CreateUsersResponse();
    }

    /**
     * Create an instance of {@link DeleteUsers }
     * 
     */
    public DeleteUsers createDeleteUsers() {
        return new DeleteUsers();
    }

    /**
     * Create an instance of {@link DeleteUsersResponse }
     * 
     */
    public DeleteUsersResponse createDeleteUsersResponse() {
        return new DeleteUsersResponse();
    }

    /**
     * Create an instance of {@link SetUser }
     * 
     */
    public SetUser createSetUser() {
        return new SetUser();
    }

    /**
     * Create an instance of {@link SetUserResponse }
     * 
     */
    public SetUserResponse createSetUserResponse() {
        return new SetUserResponse();
    }

    /**
     * Create an instance of {@link GetWsdlUrl }
     * 
     */
    public GetWsdlUrl createGetWsdlUrl() {
        return new GetWsdlUrl();
    }

    /**
     * Create an instance of {@link GetWsdlUrlResponse }
     * 
     */
    public GetWsdlUrlResponse createGetWsdlUrlResponse() {
        return new GetWsdlUrlResponse();
    }

    /**
     * Create an instance of {@link GetPasswordComplexityOptions }
     * 
     */
    public GetPasswordComplexityOptions createGetPasswordComplexityOptions() {
        return new GetPasswordComplexityOptions();
    }

    /**
     * Create an instance of {@link GetPasswordComplexityOptionsResponse }
     * 
     */
    public GetPasswordComplexityOptionsResponse createGetPasswordComplexityOptionsResponse() {
        return new GetPasswordComplexityOptionsResponse();
    }

    /**
     * Create an instance of {@link GetPasswordComplexityConfiguration }
     * 
     */
    public GetPasswordComplexityConfiguration createGetPasswordComplexityConfiguration() {
        return new GetPasswordComplexityConfiguration();
    }

    /**
     * Create an instance of {@link GetPasswordComplexityConfigurationResponse }
     * 
     */
    public GetPasswordComplexityConfigurationResponse createGetPasswordComplexityConfigurationResponse() {
        return new GetPasswordComplexityConfigurationResponse();
    }

    /**
     * Create an instance of {@link SetPasswordComplexityConfiguration }
     * 
     */
    public SetPasswordComplexityConfiguration createSetPasswordComplexityConfiguration() {
        return new SetPasswordComplexityConfiguration();
    }

    /**
     * Create an instance of {@link SetPasswordComplexityConfigurationResponse }
     * 
     */
    public SetPasswordComplexityConfigurationResponse createSetPasswordComplexityConfigurationResponse() {
        return new SetPasswordComplexityConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetPasswordHistoryConfiguration }
     * 
     */
    public GetPasswordHistoryConfiguration createGetPasswordHistoryConfiguration() {
        return new GetPasswordHistoryConfiguration();
    }

    /**
     * Create an instance of {@link GetPasswordHistoryConfigurationResponse }
     * 
     */
    public GetPasswordHistoryConfigurationResponse createGetPasswordHistoryConfigurationResponse() {
        return new GetPasswordHistoryConfigurationResponse();
    }

    /**
     * Create an instance of {@link SetPasswordHistoryConfiguration }
     * 
     */
    public SetPasswordHistoryConfiguration createSetPasswordHistoryConfiguration() {
        return new SetPasswordHistoryConfiguration();
    }

    /**
     * Create an instance of {@link SetPasswordHistoryConfigurationResponse }
     * 
     */
    public SetPasswordHistoryConfigurationResponse createSetPasswordHistoryConfigurationResponse() {
        return new SetPasswordHistoryConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetAuthFailureWarningOptions }
     * 
     */
    public GetAuthFailureWarningOptions createGetAuthFailureWarningOptions() {
        return new GetAuthFailureWarningOptions();
    }

    /**
     * Create an instance of {@link GetAuthFailureWarningOptionsResponse }
     * 
     */
    public GetAuthFailureWarningOptionsResponse createGetAuthFailureWarningOptionsResponse() {
        return new GetAuthFailureWarningOptionsResponse();
    }

    /**
     * Create an instance of {@link GetAuthFailureWarningConfiguration }
     * 
     */
    public GetAuthFailureWarningConfiguration createGetAuthFailureWarningConfiguration() {
        return new GetAuthFailureWarningConfiguration();
    }

    /**
     * Create an instance of {@link GetAuthFailureWarningConfigurationResponse }
     * 
     */
    public GetAuthFailureWarningConfigurationResponse createGetAuthFailureWarningConfigurationResponse() {
        return new GetAuthFailureWarningConfigurationResponse();
    }

    /**
     * Create an instance of {@link SetAuthFailureWarningConfiguration }
     * 
     */
    public SetAuthFailureWarningConfiguration createSetAuthFailureWarningConfiguration() {
        return new SetAuthFailureWarningConfiguration();
    }

    /**
     * Create an instance of {@link SetAuthFailureWarningConfigurationResponse }
     * 
     */
    public SetAuthFailureWarningConfigurationResponse createSetAuthFailureWarningConfigurationResponse() {
        return new SetAuthFailureWarningConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetCapabilities }
     * 
     */
    public GetCapabilities createGetCapabilities() {
        return new GetCapabilities();
    }

    /**
     * Create an instance of {@link GetCapabilitiesResponse }
     * 
     */
    public GetCapabilitiesResponse createGetCapabilitiesResponse() {
        return new GetCapabilitiesResponse();
    }

    /**
     * Create an instance of {@link GetHostname }
     * 
     */
    public GetHostname createGetHostname() {
        return new GetHostname();
    }

    /**
     * Create an instance of {@link GetHostnameResponse }
     * 
     */
    public GetHostnameResponse createGetHostnameResponse() {
        return new GetHostnameResponse();
    }

    /**
     * Create an instance of {@link SetHostname }
     * 
     */
    public SetHostname createSetHostname() {
        return new SetHostname();
    }

    /**
     * Create an instance of {@link SetHostnameResponse }
     * 
     */
    public SetHostnameResponse createSetHostnameResponse() {
        return new SetHostnameResponse();
    }

    /**
     * Create an instance of {@link SetHostnameFromDHCP }
     * 
     */
    public SetHostnameFromDHCP createSetHostnameFromDHCP() {
        return new SetHostnameFromDHCP();
    }

    /**
     * Create an instance of {@link SetHostnameFromDHCPResponse }
     * 
     */
    public SetHostnameFromDHCPResponse createSetHostnameFromDHCPResponse() {
        return new SetHostnameFromDHCPResponse();
    }

    /**
     * Create an instance of {@link GetDNS }
     * 
     */
    public GetDNS createGetDNS() {
        return new GetDNS();
    }

    /**
     * Create an instance of {@link GetDNSResponse }
     * 
     */
    public GetDNSResponse createGetDNSResponse() {
        return new GetDNSResponse();
    }

    /**
     * Create an instance of {@link SetDNS }
     * 
     */
    public SetDNS createSetDNS() {
        return new SetDNS();
    }

    /**
     * Create an instance of {@link SetDNSResponse }
     * 
     */
    public SetDNSResponse createSetDNSResponse() {
        return new SetDNSResponse();
    }

    /**
     * Create an instance of {@link GetNTP }
     * 
     */
    public GetNTP createGetNTP() {
        return new GetNTP();
    }

    /**
     * Create an instance of {@link GetNTPResponse }
     * 
     */
    public GetNTPResponse createGetNTPResponse() {
        return new GetNTPResponse();
    }

    /**
     * Create an instance of {@link SetNTP }
     * 
     */
    public SetNTP createSetNTP() {
        return new SetNTP();
    }

    /**
     * Create an instance of {@link SetNTPResponse }
     * 
     */
    public SetNTPResponse createSetNTPResponse() {
        return new SetNTPResponse();
    }

    /**
     * Create an instance of {@link GetDynamicDNS }
     * 
     */
    public GetDynamicDNS createGetDynamicDNS() {
        return new GetDynamicDNS();
    }

    /**
     * Create an instance of {@link GetDynamicDNSResponse }
     * 
     */
    public GetDynamicDNSResponse createGetDynamicDNSResponse() {
        return new GetDynamicDNSResponse();
    }

    /**
     * Create an instance of {@link SetDynamicDNS }
     * 
     */
    public SetDynamicDNS createSetDynamicDNS() {
        return new SetDynamicDNS();
    }

    /**
     * Create an instance of {@link SetDynamicDNSResponse }
     * 
     */
    public SetDynamicDNSResponse createSetDynamicDNSResponse() {
        return new SetDynamicDNSResponse();
    }

    /**
     * Create an instance of {@link GetNetworkInterfaces }
     * 
     */
    public GetNetworkInterfaces createGetNetworkInterfaces() {
        return new GetNetworkInterfaces();
    }

    /**
     * Create an instance of {@link GetNetworkInterfacesResponse }
     * 
     */
    public GetNetworkInterfacesResponse createGetNetworkInterfacesResponse() {
        return new GetNetworkInterfacesResponse();
    }

    /**
     * Create an instance of {@link SetNetworkInterfaces }
     * 
     */
    public SetNetworkInterfaces createSetNetworkInterfaces() {
        return new SetNetworkInterfaces();
    }

    /**
     * Create an instance of {@link SetNetworkInterfacesResponse }
     * 
     */
    public SetNetworkInterfacesResponse createSetNetworkInterfacesResponse() {
        return new SetNetworkInterfacesResponse();
    }

    /**
     * Create an instance of {@link GetNetworkProtocols }
     * 
     */
    public GetNetworkProtocols createGetNetworkProtocols() {
        return new GetNetworkProtocols();
    }

    /**
     * Create an instance of {@link GetNetworkProtocolsResponse }
     * 
     */
    public GetNetworkProtocolsResponse createGetNetworkProtocolsResponse() {
        return new GetNetworkProtocolsResponse();
    }

    /**
     * Create an instance of {@link SetNetworkProtocols }
     * 
     */
    public SetNetworkProtocols createSetNetworkProtocols() {
        return new SetNetworkProtocols();
    }

    /**
     * Create an instance of {@link SetNetworkProtocolsResponse }
     * 
     */
    public SetNetworkProtocolsResponse createSetNetworkProtocolsResponse() {
        return new SetNetworkProtocolsResponse();
    }

    /**
     * Create an instance of {@link GetNetworkDefaultGateway }
     * 
     */
    public GetNetworkDefaultGateway createGetNetworkDefaultGateway() {
        return new GetNetworkDefaultGateway();
    }

    /**
     * Create an instance of {@link GetNetworkDefaultGatewayResponse }
     * 
     */
    public GetNetworkDefaultGatewayResponse createGetNetworkDefaultGatewayResponse() {
        return new GetNetworkDefaultGatewayResponse();
    }

    /**
     * Create an instance of {@link SetNetworkDefaultGateway }
     * 
     */
    public SetNetworkDefaultGateway createSetNetworkDefaultGateway() {
        return new SetNetworkDefaultGateway();
    }

    /**
     * Create an instance of {@link SetNetworkDefaultGatewayResponse }
     * 
     */
    public SetNetworkDefaultGatewayResponse createSetNetworkDefaultGatewayResponse() {
        return new SetNetworkDefaultGatewayResponse();
    }

    /**
     * Create an instance of {@link GetZeroConfiguration }
     * 
     */
    public GetZeroConfiguration createGetZeroConfiguration() {
        return new GetZeroConfiguration();
    }

    /**
     * Create an instance of {@link GetZeroConfigurationResponse }
     * 
     */
    public GetZeroConfigurationResponse createGetZeroConfigurationResponse() {
        return new GetZeroConfigurationResponse();
    }

    /**
     * Create an instance of {@link SetZeroConfiguration }
     * 
     */
    public SetZeroConfiguration createSetZeroConfiguration() {
        return new SetZeroConfiguration();
    }

    /**
     * Create an instance of {@link SetZeroConfigurationResponse }
     * 
     */
    public SetZeroConfigurationResponse createSetZeroConfigurationResponse() {
        return new SetZeroConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetIPAddressFilter }
     * 
     */
    public GetIPAddressFilter createGetIPAddressFilter() {
        return new GetIPAddressFilter();
    }

    /**
     * Create an instance of {@link GetIPAddressFilterResponse }
     * 
     */
    public GetIPAddressFilterResponse createGetIPAddressFilterResponse() {
        return new GetIPAddressFilterResponse();
    }

    /**
     * Create an instance of {@link SetIPAddressFilter }
     * 
     */
    public SetIPAddressFilter createSetIPAddressFilter() {
        return new SetIPAddressFilter();
    }

    /**
     * Create an instance of {@link SetIPAddressFilterResponse }
     * 
     */
    public SetIPAddressFilterResponse createSetIPAddressFilterResponse() {
        return new SetIPAddressFilterResponse();
    }

    /**
     * Create an instance of {@link AddIPAddressFilter }
     * 
     */
    public AddIPAddressFilter createAddIPAddressFilter() {
        return new AddIPAddressFilter();
    }

    /**
     * Create an instance of {@link AddIPAddressFilterResponse }
     * 
     */
    public AddIPAddressFilterResponse createAddIPAddressFilterResponse() {
        return new AddIPAddressFilterResponse();
    }

    /**
     * Create an instance of {@link RemoveIPAddressFilter }
     * 
     */
    public RemoveIPAddressFilter createRemoveIPAddressFilter() {
        return new RemoveIPAddressFilter();
    }

    /**
     * Create an instance of {@link RemoveIPAddressFilterResponse }
     * 
     */
    public RemoveIPAddressFilterResponse createRemoveIPAddressFilterResponse() {
        return new RemoveIPAddressFilterResponse();
    }

    /**
     * Create an instance of {@link GetAccessPolicy }
     * 
     */
    public GetAccessPolicy createGetAccessPolicy() {
        return new GetAccessPolicy();
    }

    /**
     * Create an instance of {@link GetAccessPolicyResponse }
     * 
     */
    public GetAccessPolicyResponse createGetAccessPolicyResponse() {
        return new GetAccessPolicyResponse();
    }

    /**
     * Create an instance of {@link SetAccessPolicy }
     * 
     */
    public SetAccessPolicy createSetAccessPolicy() {
        return new SetAccessPolicy();
    }

    /**
     * Create an instance of {@link SetAccessPolicyResponse }
     * 
     */
    public SetAccessPolicyResponse createSetAccessPolicyResponse() {
        return new SetAccessPolicyResponse();
    }

    /**
     * Create an instance of {@link CreateCertificate }
     * 
     */
    public CreateCertificate createCreateCertificate() {
        return new CreateCertificate();
    }

    /**
     * Create an instance of {@link CreateCertificateResponse }
     * 
     */
    public CreateCertificateResponse createCreateCertificateResponse() {
        return new CreateCertificateResponse();
    }

    /**
     * Create an instance of {@link GetCertificates }
     * 
     */
    public GetCertificates createGetCertificates() {
        return new GetCertificates();
    }

    /**
     * Create an instance of {@link GetCertificatesResponse }
     * 
     */
    public GetCertificatesResponse createGetCertificatesResponse() {
        return new GetCertificatesResponse();
    }

    /**
     * Create an instance of {@link GetCertificatesStatus }
     * 
     */
    public GetCertificatesStatus createGetCertificatesStatus() {
        return new GetCertificatesStatus();
    }

    /**
     * Create an instance of {@link GetCertificatesStatusResponse }
     * 
     */
    public GetCertificatesStatusResponse createGetCertificatesStatusResponse() {
        return new GetCertificatesStatusResponse();
    }

    /**
     * Create an instance of {@link SetCertificatesStatus }
     * 
     */
    public SetCertificatesStatus createSetCertificatesStatus() {
        return new SetCertificatesStatus();
    }

    /**
     * Create an instance of {@link SetCertificatesStatusResponse }
     * 
     */
    public SetCertificatesStatusResponse createSetCertificatesStatusResponse() {
        return new SetCertificatesStatusResponse();
    }

    /**
     * Create an instance of {@link DeleteCertificates }
     * 
     */
    public DeleteCertificates createDeleteCertificates() {
        return new DeleteCertificates();
    }

    /**
     * Create an instance of {@link DeleteCertificatesResponse }
     * 
     */
    public DeleteCertificatesResponse createDeleteCertificatesResponse() {
        return new DeleteCertificatesResponse();
    }

    /**
     * Create an instance of {@link GetPkcs10Request }
     * 
     */
    public GetPkcs10Request createGetPkcs10Request() {
        return new GetPkcs10Request();
    }

    /**
     * Create an instance of {@link GetPkcs10RequestResponse }
     * 
     */
    public GetPkcs10RequestResponse createGetPkcs10RequestResponse() {
        return new GetPkcs10RequestResponse();
    }

    /**
     * Create an instance of {@link LoadCertificates }
     * 
     */
    public LoadCertificates createLoadCertificates() {
        return new LoadCertificates();
    }

    /**
     * Create an instance of {@link LoadCertificatesResponse }
     * 
     */
    public LoadCertificatesResponse createLoadCertificatesResponse() {
        return new LoadCertificatesResponse();
    }

    /**
     * Create an instance of {@link GetClientCertificateMode }
     * 
     */
    public GetClientCertificateMode createGetClientCertificateMode() {
        return new GetClientCertificateMode();
    }

    /**
     * Create an instance of {@link GetClientCertificateModeResponse }
     * 
     */
    public GetClientCertificateModeResponse createGetClientCertificateModeResponse() {
        return new GetClientCertificateModeResponse();
    }

    /**
     * Create an instance of {@link SetClientCertificateMode }
     * 
     */
    public SetClientCertificateMode createSetClientCertificateMode() {
        return new SetClientCertificateMode();
    }

    /**
     * Create an instance of {@link SetClientCertificateModeResponse }
     * 
     */
    public SetClientCertificateModeResponse createSetClientCertificateModeResponse() {
        return new SetClientCertificateModeResponse();
    }

    /**
     * Create an instance of {@link GetCACertificates }
     * 
     */
    public GetCACertificates createGetCACertificates() {
        return new GetCACertificates();
    }

    /**
     * Create an instance of {@link GetCACertificatesResponse }
     * 
     */
    public GetCACertificatesResponse createGetCACertificatesResponse() {
        return new GetCACertificatesResponse();
    }

    /**
     * Create an instance of {@link LoadCertificateWithPrivateKey }
     * 
     */
    public LoadCertificateWithPrivateKey createLoadCertificateWithPrivateKey() {
        return new LoadCertificateWithPrivateKey();
    }

    /**
     * Create an instance of {@link LoadCertificateWithPrivateKeyResponse }
     * 
     */
    public LoadCertificateWithPrivateKeyResponse createLoadCertificateWithPrivateKeyResponse() {
        return new LoadCertificateWithPrivateKeyResponse();
    }

    /**
     * Create an instance of {@link GetCertificateInformation }
     * 
     */
    public GetCertificateInformation createGetCertificateInformation() {
        return new GetCertificateInformation();
    }

    /**
     * Create an instance of {@link GetCertificateInformationResponse }
     * 
     */
    public GetCertificateInformationResponse createGetCertificateInformationResponse() {
        return new GetCertificateInformationResponse();
    }

    /**
     * Create an instance of {@link LoadCACertificates }
     * 
     */
    public LoadCACertificates createLoadCACertificates() {
        return new LoadCACertificates();
    }

    /**
     * Create an instance of {@link LoadCACertificatesResponse }
     * 
     */
    public LoadCACertificatesResponse createLoadCACertificatesResponse() {
        return new LoadCACertificatesResponse();
    }

    /**
     * Create an instance of {@link CreateDot1XConfiguration }
     * 
     */
    public CreateDot1XConfiguration createCreateDot1XConfiguration() {
        return new CreateDot1XConfiguration();
    }

    /**
     * Create an instance of {@link CreateDot1XConfigurationResponse }
     * 
     */
    public CreateDot1XConfigurationResponse createCreateDot1XConfigurationResponse() {
        return new CreateDot1XConfigurationResponse();
    }

    /**
     * Create an instance of {@link SetDot1XConfiguration }
     * 
     */
    public SetDot1XConfiguration createSetDot1XConfiguration() {
        return new SetDot1XConfiguration();
    }

    /**
     * Create an instance of {@link SetDot1XConfigurationResponse }
     * 
     */
    public SetDot1XConfigurationResponse createSetDot1XConfigurationResponse() {
        return new SetDot1XConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetDot1XConfiguration }
     * 
     */
    public GetDot1XConfiguration createGetDot1XConfiguration() {
        return new GetDot1XConfiguration();
    }

    /**
     * Create an instance of {@link GetDot1XConfigurationResponse }
     * 
     */
    public GetDot1XConfigurationResponse createGetDot1XConfigurationResponse() {
        return new GetDot1XConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetDot1XConfigurations }
     * 
     */
    public GetDot1XConfigurations createGetDot1XConfigurations() {
        return new GetDot1XConfigurations();
    }

    /**
     * Create an instance of {@link GetDot1XConfigurationsResponse }
     * 
     */
    public GetDot1XConfigurationsResponse createGetDot1XConfigurationsResponse() {
        return new GetDot1XConfigurationsResponse();
    }

    /**
     * Create an instance of {@link DeleteDot1XConfiguration }
     * 
     */
    public DeleteDot1XConfiguration createDeleteDot1XConfiguration() {
        return new DeleteDot1XConfiguration();
    }

    /**
     * Create an instance of {@link DeleteDot1XConfigurationResponse }
     * 
     */
    public DeleteDot1XConfigurationResponse createDeleteDot1XConfigurationResponse() {
        return new DeleteDot1XConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetRelayOutputs }
     * 
     */
    public GetRelayOutputs createGetRelayOutputs() {
        return new GetRelayOutputs();
    }

    /**
     * Create an instance of {@link GetRelayOutputsResponse }
     * 
     */
    public GetRelayOutputsResponse createGetRelayOutputsResponse() {
        return new GetRelayOutputsResponse();
    }

    /**
     * Create an instance of {@link SetRelayOutputSettings }
     * 
     */
    public SetRelayOutputSettings createSetRelayOutputSettings() {
        return new SetRelayOutputSettings();
    }

    /**
     * Create an instance of {@link SetRelayOutputSettingsResponse }
     * 
     */
    public SetRelayOutputSettingsResponse createSetRelayOutputSettingsResponse() {
        return new SetRelayOutputSettingsResponse();
    }

    /**
     * Create an instance of {@link SetRelayOutputState }
     * 
     */
    public SetRelayOutputState createSetRelayOutputState() {
        return new SetRelayOutputState();
    }

    /**
     * Create an instance of {@link SetRelayOutputStateResponse }
     * 
     */
    public SetRelayOutputStateResponse createSetRelayOutputStateResponse() {
        return new SetRelayOutputStateResponse();
    }

    /**
     * Create an instance of {@link SendAuxiliaryCommand }
     * 
     */
    public SendAuxiliaryCommand createSendAuxiliaryCommand() {
        return new SendAuxiliaryCommand();
    }

    /**
     * Create an instance of {@link SendAuxiliaryCommandResponse }
     * 
     */
    public SendAuxiliaryCommandResponse createSendAuxiliaryCommandResponse() {
        return new SendAuxiliaryCommandResponse();
    }

    /**
     * Create an instance of {@link GetDot11Capabilities }
     * 
     */
    public GetDot11Capabilities createGetDot11Capabilities() {
        return new GetDot11Capabilities();
    }

    /**
     * Create an instance of {@link GetDot11CapabilitiesResponse }
     * 
     */
    public GetDot11CapabilitiesResponse createGetDot11CapabilitiesResponse() {
        return new GetDot11CapabilitiesResponse();
    }

    /**
     * Create an instance of {@link GetDot11Status }
     * 
     */
    public GetDot11Status createGetDot11Status() {
        return new GetDot11Status();
    }

    /**
     * Create an instance of {@link GetDot11StatusResponse }
     * 
     */
    public GetDot11StatusResponse createGetDot11StatusResponse() {
        return new GetDot11StatusResponse();
    }

    /**
     * Create an instance of {@link ScanAvailableDot11Networks }
     * 
     */
    public ScanAvailableDot11Networks createScanAvailableDot11Networks() {
        return new ScanAvailableDot11Networks();
    }

    /**
     * Create an instance of {@link ScanAvailableDot11NetworksResponse }
     * 
     */
    public ScanAvailableDot11NetworksResponse createScanAvailableDot11NetworksResponse() {
        return new ScanAvailableDot11NetworksResponse();
    }

    /**
     * Create an instance of {@link GetSystemUris }
     * 
     */
    public GetSystemUris createGetSystemUris() {
        return new GetSystemUris();
    }

    /**
     * Create an instance of {@link GetSystemUrisResponse.Extension }
     * 
     */
    public GetSystemUrisResponse.Extension createGetSystemUrisResponseExtension() {
        return new GetSystemUrisResponse.Extension();
    }

    /**
     * Create an instance of {@link StartFirmwareUpgrade }
     * 
     */
    public StartFirmwareUpgrade createStartFirmwareUpgrade() {
        return new StartFirmwareUpgrade();
    }

    /**
     * Create an instance of {@link StartFirmwareUpgradeResponse }
     * 
     */
    public StartFirmwareUpgradeResponse createStartFirmwareUpgradeResponse() {
        return new StartFirmwareUpgradeResponse();
    }

    /**
     * Create an instance of {@link StartSystemRestore }
     * 
     */
    public StartSystemRestore createStartSystemRestore() {
        return new StartSystemRestore();
    }

    /**
     * Create an instance of {@link StartSystemRestoreResponse }
     * 
     */
    public StartSystemRestoreResponse createStartSystemRestoreResponse() {
        return new StartSystemRestoreResponse();
    }

    /**
     * Create an instance of {@link SetHashingAlgorithm }
     * 
     */
    public SetHashingAlgorithm createSetHashingAlgorithm() {
        return new SetHashingAlgorithm();
    }

    /**
     * Create an instance of {@link SetHashingAlgorithmResponse }
     * 
     */
    public SetHashingAlgorithmResponse createSetHashingAlgorithmResponse() {
        return new SetHashingAlgorithmResponse();
    }

    /**
     * Create an instance of {@link GetStorageConfigurations }
     * 
     */
    public GetStorageConfigurations createGetStorageConfigurations() {
        return new GetStorageConfigurations();
    }

    /**
     * Create an instance of {@link GetStorageConfigurationsResponse }
     * 
     */
    public GetStorageConfigurationsResponse createGetStorageConfigurationsResponse() {
        return new GetStorageConfigurationsResponse();
    }

    /**
     * Create an instance of {@link StorageConfiguration }
     * 
     */
    public StorageConfiguration createStorageConfiguration() {
        return new StorageConfiguration();
    }

    /**
     * Create an instance of {@link CreateStorageConfiguration }
     * 
     */
    public CreateStorageConfiguration createCreateStorageConfiguration() {
        return new CreateStorageConfiguration();
    }

    /**
     * Create an instance of {@link CreateStorageConfigurationResponse }
     * 
     */
    public CreateStorageConfigurationResponse createCreateStorageConfigurationResponse() {
        return new CreateStorageConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetStorageConfiguration }
     * 
     */
    public GetStorageConfiguration createGetStorageConfiguration() {
        return new GetStorageConfiguration();
    }

    /**
     * Create an instance of {@link GetStorageConfigurationResponse }
     * 
     */
    public GetStorageConfigurationResponse createGetStorageConfigurationResponse() {
        return new GetStorageConfigurationResponse();
    }

    /**
     * Create an instance of {@link SetStorageConfiguration }
     * 
     */
    public SetStorageConfiguration createSetStorageConfiguration() {
        return new SetStorageConfiguration();
    }

    /**
     * Create an instance of {@link SetStorageConfigurationResponse }
     * 
     */
    public SetStorageConfigurationResponse createSetStorageConfigurationResponse() {
        return new SetStorageConfigurationResponse();
    }

    /**
     * Create an instance of {@link DeleteStorageConfiguration }
     * 
     */
    public DeleteStorageConfiguration createDeleteStorageConfiguration() {
        return new DeleteStorageConfiguration();
    }

    /**
     * Create an instance of {@link DeleteStorageConfigurationResponse }
     * 
     */
    public DeleteStorageConfigurationResponse createDeleteStorageConfigurationResponse() {
        return new DeleteStorageConfigurationResponse();
    }

    /**
     * Create an instance of {@link GetGeoLocation }
     * 
     */
    public GetGeoLocation createGetGeoLocation() {
        return new GetGeoLocation();
    }

    /**
     * Create an instance of {@link GetGeoLocationResponse }
     * 
     */
    public GetGeoLocationResponse createGetGeoLocationResponse() {
        return new GetGeoLocationResponse();
    }

    /**
     * Create an instance of {@link SetGeoLocation }
     * 
     */
    public SetGeoLocation createSetGeoLocation() {
        return new SetGeoLocation();
    }

    /**
     * Create an instance of {@link SetGeoLocationResponse }
     * 
     */
    public SetGeoLocationResponse createSetGeoLocationResponse() {
        return new SetGeoLocationResponse();
    }

    /**
     * Create an instance of {@link DeleteGeoLocation }
     * 
     */
    public DeleteGeoLocation createDeleteGeoLocation() {
        return new DeleteGeoLocation();
    }

    /**
     * Create an instance of {@link DeleteGeoLocationResponse }
     * 
     */
    public DeleteGeoLocationResponse createDeleteGeoLocationResponse() {
        return new DeleteGeoLocationResponse();
    }

    /**
     * Create an instance of {@link NetworkCapabilities2 }
     * 
     */
    public NetworkCapabilities2 createNetworkCapabilities2() {
        return new NetworkCapabilities2();
    }

    /**
     * Create an instance of {@link SecurityCapabilities2 }
     * 
     */
    public SecurityCapabilities2 createSecurityCapabilities2() {
        return new SecurityCapabilities2();
    }

    /**
     * Create an instance of {@link SystemCapabilities2 }
     * 
     */
    public SystemCapabilities2 createSystemCapabilities2() {
        return new SystemCapabilities2();
    }

    /**
     * Create an instance of {@link MiscCapabilities }
     * 
     */
    public MiscCapabilities createMiscCapabilities() {
        return new MiscCapabilities();
    }

    /**
     * Create an instance of {@link UserCredential.Extension }
     * 
     */
    public UserCredential.Extension createUserCredentialExtension() {
        return new UserCredential.Extension();
    }

    /**
     * Create an instance of {@link StorageConfigurationData.Extension }
     * 
     */
    public StorageConfigurationData.Extension createStorageConfigurationDataExtension() {
        return new StorageConfigurationData.Extension();
    }

    /**
     * Create an instance of {@link Service.Capabilities }
     * 
     */
    public Service.Capabilities createServiceCapabilities() {
        return new Service.Capabilities();
    }

    /**
     * Create an instance of {@link RecordingEventFilter.Filter }
     * 
     */
    public RecordingEventFilter.Filter createRecordingEventFilterFilter() {
        return new RecordingEventFilter.Filter();
    }

    /**
     * Create an instance of {@link ConfigDescription.Messages }
     * 
     */
    public ConfigDescription.Messages createConfigDescriptionMessages() {
        return new ConfigDescription.Messages();
    }

    /**
     * Create an instance of {@link ItemListDescription.SimpleItemDescription }
     * 
     */
    public ItemListDescription.SimpleItemDescription createItemListDescriptionSimpleItemDescription() {
        return new ItemListDescription.SimpleItemDescription();
    }

    /**
     * Create an instance of {@link ItemListDescription.ElementItemDescription }
     * 
     */
    public ItemListDescription.ElementItemDescription createItemListDescriptionElementItemDescription() {
        return new ItemListDescription.ElementItemDescription();
    }

    /**
     * Create an instance of {@link EventSubscription.SubscriptionPolicy }
     * 
     */
    public EventSubscription.SubscriptionPolicy createEventSubscriptionSubscriptionPolicy() {
        return new EventSubscription.SubscriptionPolicy();
    }

    /**
     * Create an instance of {@link ColorDescriptor.ColorCluster }
     * 
     */
    public ColorDescriptor.ColorCluster createColorDescriptorColorCluster() {
        return new ColorDescriptor.ColorCluster();
    }

    /**
     * Create an instance of {@link ItemList.SimpleItem }
     * 
     */
    public ItemList.SimpleItem createItemListSimpleItem() {
        return new ItemList.SimpleItem();
    }

    /**
     * Create an instance of {@link ItemList.ElementItem }
     * 
     */
    public ItemList.ElementItem createItemListElementItem() {
        return new ItemList.ElementItem();
    }

    /**
     * Create an instance of {@link BaseFaultType.ErrorCode }
     * 
     */
    public BaseFaultType.ErrorCode createBaseFaultTypeErrorCode() {
        return new BaseFaultType.ErrorCode();
    }

    /**
     * Create an instance of {@link BaseFaultType.Description }
     * 
     */
    public BaseFaultType.Description createBaseFaultTypeDescription() {
        return new BaseFaultType.Description();
    }

    /**
     * Create an instance of {@link BaseFaultType.FaultCause }
     * 
     */
    public BaseFaultType.FaultCause createBaseFaultTypeFaultCause() {
        return new BaseFaultType.FaultCause();
    }

    /**
     * Create an instance of {@link NotificationMessageHolderType.Message }
     * 
     */
    public NotificationMessageHolderType.Message createNotificationMessageHolderTypeMessage() {
        return new NotificationMessageHolderType.Message();
    }

    /**
     * Create an instance of {@link TopicNamespaceType.Topic }
     * 
     */
    public TopicNamespaceType.Topic createTopicNamespaceTypeTopic() {
        return new TopicNamespaceType.Topic();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopicNamespaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopicNamespaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/t-1", name = "TopicNamespace")
    public JAXBElement<TopicNamespaceType> createTopicNamespace(TopicNamespaceType value) {
        return new JAXBElement<TopicNamespaceType>(_TopicNamespace_QNAME, TopicNamespaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopicSetType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopicSetType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/t-1", name = "TopicSet")
    public JAXBElement<TopicSetType> createTopicSet(TopicSetType value) {
        return new JAXBElement<TopicSetType>(_TopicSet_QNAME, TopicSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BaseFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsrf/bf-2", name = "BaseFault")
    public JAXBElement<BaseFaultType> createBaseFault(BaseFaultType value) {
        return new JAXBElement<BaseFaultType>(_BaseFault_QNAME, BaseFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopicExpressionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopicExpressionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "TopicExpression")
    public JAXBElement<TopicExpressionType> createTopicExpression(TopicExpressionType value) {
        return new JAXBElement<TopicExpressionType>(_TopicExpression_QNAME, TopicExpressionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "FixedTopicSet", defaultValue = "true")
    public JAXBElement<Boolean> createFixedTopicSet(Boolean value) {
        return new JAXBElement<Boolean>(_FixedTopicSet_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "TopicExpressionDialect")
    public JAXBElement<String> createTopicExpressionDialect(String value) {
        return new JAXBElement<String>(_TopicExpressionDialect_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link W3CEndpointReference }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link W3CEndpointReference }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "ConsumerReference")
    public JAXBElement<W3CEndpointReference> createConsumerReference(W3CEndpointReference value) {
        return new JAXBElement<W3CEndpointReference>(_ConsumerReference_QNAME, W3CEndpointReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "Filter")
    public JAXBElement<FilterType> createFilter(FilterType value) {
        return new JAXBElement<FilterType>(_Filter_QNAME, FilterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriptionPolicyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubscriptionPolicyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "SubscriptionPolicy")
    public JAXBElement<SubscriptionPolicyType> createSubscriptionPolicy(SubscriptionPolicyType value) {
        return new JAXBElement<SubscriptionPolicyType>(_SubscriptionPolicy_QNAME, SubscriptionPolicyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "CreationTime")
    public JAXBElement<XMLGregorianCalendar> createCreationTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CreationTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link W3CEndpointReference }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link W3CEndpointReference }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "SubscriptionReference")
    public JAXBElement<W3CEndpointReference> createSubscriptionReference(W3CEndpointReference value) {
        return new JAXBElement<W3CEndpointReference>(_SubscriptionReference_QNAME, W3CEndpointReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopicExpressionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopicExpressionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "Topic")
    public JAXBElement<TopicExpressionType> createTopic(TopicExpressionType value) {
        return new JAXBElement<TopicExpressionType>(_Topic_QNAME, TopicExpressionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link W3CEndpointReference }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link W3CEndpointReference }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "ProducerReference")
    public JAXBElement<W3CEndpointReference> createProducerReference(W3CEndpointReference value) {
        return new JAXBElement<W3CEndpointReference>(_ProducerReference_QNAME, W3CEndpointReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificationMessageHolderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotificationMessageHolderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "NotificationMessage")
    public JAXBElement<NotificationMessageHolderType> createNotificationMessage(NotificationMessageHolderType value) {
        return new JAXBElement<NotificationMessageHolderType>(_NotificationMessage_QNAME, NotificationMessageHolderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "CurrentTime")
    public JAXBElement<XMLGregorianCalendar> createCurrentTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CurrentTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "TerminationTime")
    public JAXBElement<XMLGregorianCalendar> createTerminationTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TerminationTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryExpressionType2 }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryExpressionType2 }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "ProducerProperties")
    public JAXBElement<QueryExpressionType2> createProducerProperties(QueryExpressionType2 value) {
        return new JAXBElement<QueryExpressionType2>(_ProducerProperties_QNAME, QueryExpressionType2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryExpressionType2 }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryExpressionType2 }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "MessageContent")
    public JAXBElement<QueryExpressionType2> createMessageContent(QueryExpressionType2 value) {
        return new JAXBElement<QueryExpressionType2>(_MessageContent_QNAME, QueryExpressionType2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeCreationFailedFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubscribeCreationFailedFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "SubscribeCreationFailedFault")
    public JAXBElement<SubscribeCreationFailedFaultType> createSubscribeCreationFailedFault(SubscribeCreationFailedFaultType value) {
        return new JAXBElement<SubscribeCreationFailedFaultType>(_SubscribeCreationFailedFault_QNAME, SubscribeCreationFailedFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidFilterFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidFilterFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "InvalidFilterFault")
    public JAXBElement<InvalidFilterFaultType> createInvalidFilterFault(InvalidFilterFaultType value) {
        return new JAXBElement<InvalidFilterFaultType>(_InvalidFilterFault_QNAME, InvalidFilterFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopicExpressionDialectUnknownFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopicExpressionDialectUnknownFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "TopicExpressionDialectUnknownFault")
    public JAXBElement<TopicExpressionDialectUnknownFaultType> createTopicExpressionDialectUnknownFault(TopicExpressionDialectUnknownFaultType value) {
        return new JAXBElement<TopicExpressionDialectUnknownFaultType>(_TopicExpressionDialectUnknownFault_QNAME, TopicExpressionDialectUnknownFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidTopicExpressionFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidTopicExpressionFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "InvalidTopicExpressionFault")
    public JAXBElement<InvalidTopicExpressionFaultType> createInvalidTopicExpressionFault(InvalidTopicExpressionFaultType value) {
        return new JAXBElement<InvalidTopicExpressionFaultType>(_InvalidTopicExpressionFault_QNAME, InvalidTopicExpressionFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopicNotSupportedFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopicNotSupportedFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "TopicNotSupportedFault")
    public JAXBElement<TopicNotSupportedFaultType> createTopicNotSupportedFault(TopicNotSupportedFaultType value) {
        return new JAXBElement<TopicNotSupportedFaultType>(_TopicNotSupportedFault_QNAME, TopicNotSupportedFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultipleTopicsSpecifiedFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultipleTopicsSpecifiedFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "MultipleTopicsSpecifiedFault")
    public JAXBElement<MultipleTopicsSpecifiedFaultType> createMultipleTopicsSpecifiedFault(MultipleTopicsSpecifiedFaultType value) {
        return new JAXBElement<MultipleTopicsSpecifiedFaultType>(_MultipleTopicsSpecifiedFault_QNAME, MultipleTopicsSpecifiedFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidProducerPropertiesExpressionFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidProducerPropertiesExpressionFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "InvalidProducerPropertiesExpressionFault")
    public JAXBElement<InvalidProducerPropertiesExpressionFaultType> createInvalidProducerPropertiesExpressionFault(InvalidProducerPropertiesExpressionFaultType value) {
        return new JAXBElement<InvalidProducerPropertiesExpressionFaultType>(_InvalidProducerPropertiesExpressionFault_QNAME, InvalidProducerPropertiesExpressionFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidMessageContentExpressionFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidMessageContentExpressionFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "InvalidMessageContentExpressionFault")
    public JAXBElement<InvalidMessageContentExpressionFaultType> createInvalidMessageContentExpressionFault(InvalidMessageContentExpressionFaultType value) {
        return new JAXBElement<InvalidMessageContentExpressionFaultType>(_InvalidMessageContentExpressionFault_QNAME, InvalidMessageContentExpressionFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnrecognizedPolicyRequestFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnrecognizedPolicyRequestFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnrecognizedPolicyRequestFault")
    public JAXBElement<UnrecognizedPolicyRequestFaultType> createUnrecognizedPolicyRequestFault(UnrecognizedPolicyRequestFaultType value) {
        return new JAXBElement<UnrecognizedPolicyRequestFaultType>(_UnrecognizedPolicyRequestFault_QNAME, UnrecognizedPolicyRequestFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedPolicyRequestFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnsupportedPolicyRequestFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnsupportedPolicyRequestFault")
    public JAXBElement<UnsupportedPolicyRequestFaultType> createUnsupportedPolicyRequestFault(UnsupportedPolicyRequestFaultType value) {
        return new JAXBElement<UnsupportedPolicyRequestFaultType>(_UnsupportedPolicyRequestFault_QNAME, UnsupportedPolicyRequestFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyMessageNotSupportedFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyMessageNotSupportedFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "NotifyMessageNotSupportedFault")
    public JAXBElement<NotifyMessageNotSupportedFaultType> createNotifyMessageNotSupportedFault(NotifyMessageNotSupportedFaultType value) {
        return new JAXBElement<NotifyMessageNotSupportedFaultType>(_NotifyMessageNotSupportedFault_QNAME, NotifyMessageNotSupportedFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnacceptableInitialTerminationTimeFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnacceptableInitialTerminationTimeFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnacceptableInitialTerminationTimeFault")
    public JAXBElement<UnacceptableInitialTerminationTimeFaultType> createUnacceptableInitialTerminationTimeFault(UnacceptableInitialTerminationTimeFaultType value) {
        return new JAXBElement<UnacceptableInitialTerminationTimeFaultType>(_UnacceptableInitialTerminationTimeFault_QNAME, UnacceptableInitialTerminationTimeFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoCurrentMessageOnTopicFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NoCurrentMessageOnTopicFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "NoCurrentMessageOnTopicFault")
    public JAXBElement<NoCurrentMessageOnTopicFaultType> createNoCurrentMessageOnTopicFault(NoCurrentMessageOnTopicFaultType value) {
        return new JAXBElement<NoCurrentMessageOnTopicFaultType>(_NoCurrentMessageOnTopicFault_QNAME, NoCurrentMessageOnTopicFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToGetMessagesFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToGetMessagesFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnableToGetMessagesFault")
    public JAXBElement<UnableToGetMessagesFaultType> createUnableToGetMessagesFault(UnableToGetMessagesFaultType value) {
        return new JAXBElement<UnableToGetMessagesFaultType>(_UnableToGetMessagesFault_QNAME, UnableToGetMessagesFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToDestroyPullPointFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToDestroyPullPointFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnableToDestroyPullPointFault")
    public JAXBElement<UnableToDestroyPullPointFaultType> createUnableToDestroyPullPointFault(UnableToDestroyPullPointFaultType value) {
        return new JAXBElement<UnableToDestroyPullPointFaultType>(_UnableToDestroyPullPointFault_QNAME, UnableToDestroyPullPointFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToCreatePullPointFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToCreatePullPointFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnableToCreatePullPointFault")
    public JAXBElement<UnableToCreatePullPointFaultType> createUnableToCreatePullPointFault(UnableToCreatePullPointFaultType value) {
        return new JAXBElement<UnableToCreatePullPointFaultType>(_UnableToCreatePullPointFault_QNAME, UnableToCreatePullPointFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnacceptableTerminationTimeFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnacceptableTerminationTimeFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnacceptableTerminationTimeFault")
    public JAXBElement<UnacceptableTerminationTimeFaultType> createUnacceptableTerminationTimeFault(UnacceptableTerminationTimeFaultType value) {
        return new JAXBElement<UnacceptableTerminationTimeFaultType>(_UnacceptableTerminationTimeFault_QNAME, UnacceptableTerminationTimeFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToDestroySubscriptionFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToDestroySubscriptionFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "UnableToDestroySubscriptionFault")
    public JAXBElement<UnableToDestroySubscriptionFaultType> createUnableToDestroySubscriptionFault(UnableToDestroySubscriptionFaultType value) {
        return new JAXBElement<UnableToDestroySubscriptionFaultType>(_UnableToDestroySubscriptionFault_QNAME, UnableToDestroySubscriptionFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PauseFailedFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PauseFailedFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "PauseFailedFault")
    public JAXBElement<PauseFailedFaultType> createPauseFailedFault(PauseFailedFaultType value) {
        return new JAXBElement<PauseFailedFaultType>(_PauseFailedFault_QNAME, PauseFailedFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResumeFailedFaultType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResumeFailedFaultType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "ResumeFailedFault")
    public JAXBElement<ResumeFailedFaultType> createResumeFailedFault(ResumeFailedFaultType value) {
        return new JAXBElement<ResumeFailedFaultType>(_ResumeFailedFault_QNAME, ResumeFailedFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Include }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Include }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2004/08/xop/include", name = "Include")
    public JAXBElement<Include> createInclude(Include value) {
        return new JAXBElement<Include>(_Include_QNAME, Include.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Polygon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Polygon }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "Polygon")
    public JAXBElement<Polygon> createPolygon(Polygon value) {
        return new JAXBElement<Polygon>(_Polygon_QNAME, Polygon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "StringList")
    public JAXBElement<List<String>> createStringList(List<String> value) {
        return new JAXBElement<List<String>>(_StringList_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntRange }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IntRange }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "IntRange")
    public JAXBElement<IntRange> createIntRange(IntRange value) {
        return new JAXBElement<IntRange>(_IntRange_QNAME, IntRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Integer }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Integer }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "IntList")
    public JAXBElement<List<Integer>> createIntList(List<Integer> value) {
        return new JAXBElement<List<Integer>>(_IntList_QNAME, ((Class) List.class), null, ((List<Integer> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FloatRange }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FloatRange }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "FloatRange")
    public JAXBElement<FloatRange> createFloatRange(FloatRange value) {
        return new JAXBElement<FloatRange>(_FloatRange_QNAME, FloatRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "FloatList")
    public JAXBElement<List<Float>> createFloatList(List<Float> value) {
        return new JAXBElement<List<Float>>(_FloatList_QNAME, ((Class) List.class), null, ((List<Float> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DurationRange }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DurationRange }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "DurationRange")
    public JAXBElement<DurationRange> createDurationRange(DurationRange value) {
        return new JAXBElement<DurationRange>(_DurationRange_QNAME, DurationRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntRectangleRange }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IntRectangleRange }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "IntRectangleRange")
    public JAXBElement<IntRectangleRange> createIntRectangleRange(IntRectangleRange value) {
        return new JAXBElement<IntRectangleRange>(_IntRectangleRange_QNAME, IntRectangleRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VideoSourceConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VideoSourceConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "VideoSourceConfiguration")
    public JAXBElement<VideoSourceConfiguration> createVideoSourceConfiguration(VideoSourceConfiguration value) {
        return new JAXBElement<VideoSourceConfiguration>(_VideoSourceConfiguration_QNAME, VideoSourceConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AudioSourceConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AudioSourceConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "AudioSourceConfiguration")
    public JAXBElement<AudioSourceConfiguration> createAudioSourceConfiguration(AudioSourceConfiguration value) {
        return new JAXBElement<AudioSourceConfiguration>(_AudioSourceConfiguration_QNAME, AudioSourceConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VideoEncoderConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VideoEncoderConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "VideoEncoderConfiguration")
    public JAXBElement<VideoEncoderConfiguration> createVideoEncoderConfiguration(VideoEncoderConfiguration value) {
        return new JAXBElement<VideoEncoderConfiguration>(_VideoEncoderConfiguration_QNAME, VideoEncoderConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AudioEncoderConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AudioEncoderConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "AudioEncoderConfiguration")
    public JAXBElement<AudioEncoderConfiguration> createAudioEncoderConfiguration(AudioEncoderConfiguration value) {
        return new JAXBElement<AudioEncoderConfiguration>(_AudioEncoderConfiguration_QNAME, AudioEncoderConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VideoAnalyticsConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VideoAnalyticsConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "VideoAnalyticsConfiguration")
    public JAXBElement<VideoAnalyticsConfiguration> createVideoAnalyticsConfiguration(VideoAnalyticsConfiguration value) {
        return new JAXBElement<VideoAnalyticsConfiguration>(_VideoAnalyticsConfiguration_QNAME, VideoAnalyticsConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PTZConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PTZConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "PTZConfiguration")
    public JAXBElement<PTZConfiguration> createPTZConfiguration(PTZConfiguration value) {
        return new JAXBElement<PTZConfiguration>(_PTZConfiguration_QNAME, PTZConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetadataConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MetadataConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "MetadataConfiguration")
    public JAXBElement<MetadataConfiguration> createMetadataConfiguration(MetadataConfiguration value) {
        return new JAXBElement<MetadataConfiguration>(_MetadataConfiguration_QNAME, MetadataConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AudioOutputConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AudioOutputConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "AudioOutputConfiguration")
    public JAXBElement<AudioOutputConfiguration> createAudioOutputConfiguration(AudioOutputConfiguration value) {
        return new JAXBElement<AudioOutputConfiguration>(_AudioOutputConfiguration_QNAME, AudioOutputConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AudioDecoderConfiguration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AudioDecoderConfiguration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "AudioDecoderConfiguration")
    public JAXBElement<AudioDecoderConfiguration> createAudioDecoderConfiguration(AudioDecoderConfiguration value) {
        return new JAXBElement<AudioDecoderConfiguration>(_AudioDecoderConfiguration_QNAME, AudioDecoderConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Polyline }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Polyline }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "Polyline")
    public JAXBElement<Polyline> createPolyline(Polyline value) {
        return new JAXBElement<Polyline>(_Polyline_QNAME, Polyline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonOptions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolygonOptions }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/schema", name = "PolygonOptions")
    public JAXBElement<PolygonOptions> createPolygonOptions(PolygonOptions value) {
        return new JAXBElement<PolygonOptions>(_PolygonOptions_QNAME, PolygonOptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Envelope }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Envelope }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2003/05/soap-envelope", name = "Envelope")
    public JAXBElement<Envelope> createEnvelope(Envelope value) {
        return new JAXBElement<Envelope>(_Envelope_QNAME, Envelope.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Header }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Header }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2003/05/soap-envelope", name = "Header")
    public JAXBElement<Header> createHeader(Header value) {
        return new JAXBElement<Header>(_Header_QNAME, Header.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Body }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Body }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2003/05/soap-envelope", name = "Body")
    public JAXBElement<Body> createBody(Body value) {
        return new JAXBElement<Body>(_Body_QNAME, Body.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fault }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Fault }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2003/05/soap-envelope", name = "Fault")
    public JAXBElement<Fault> createFault(Fault value) {
        return new JAXBElement<Fault>(_Fault_QNAME, Fault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotUnderstoodType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotUnderstoodType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2003/05/soap-envelope", name = "NotUnderstood")
    public JAXBElement<NotUnderstoodType> createNotUnderstood(NotUnderstoodType value) {
        return new JAXBElement<NotUnderstoodType>(_NotUnderstood_QNAME, NotUnderstoodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpgradeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpgradeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2003/05/soap-envelope", name = "Upgrade")
    public JAXBElement<UpgradeType> createUpgrade(UpgradeType value) {
        return new JAXBElement<UpgradeType>(_Upgrade_QNAME, UpgradeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceServiceCapabilities }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeviceServiceCapabilities }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.onvif.org/ver10/device/wsdl", name = "Capabilities")
    public JAXBElement<DeviceServiceCapabilities> createCapabilities(DeviceServiceCapabilities value) {
        return new JAXBElement<DeviceServiceCapabilities>(_Capabilities_QNAME, DeviceServiceCapabilities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wsn/b-2", name = "InitialTerminationTime", scope = Subscribe.class)
    public JAXBElement<String> createSubscribeInitialTerminationTime(String value) {
        return new JAXBElement<String>(_SubscribeInitialTerminationTime_QNAME, String.class, Subscribe.class, value);
    }

}
